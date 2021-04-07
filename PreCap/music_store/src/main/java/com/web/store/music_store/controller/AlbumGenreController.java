package com.web.store.music_store.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.music_store.model.AlbumGenre;
import com.web.store.music_store.service.AlbumGenreService;

@Controller
public class AlbumGenreController {

	@Autowired
	AlbumGenreService service;
	
	@PostMapping(value="/create")
	public String createAlbum(ModelMap model, @RequestParam String name, @RequestParam String artist, @RequestParam String price, 
			@RequestParam String release_date, @RequestParam String genre_name) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
		service.create(new AlbumGenre(name, artist, price, date, genre_name));
		model.put("message", "Album has been added");
		return "index";
	}
	
	@PostMapping(value="/read")
	public String readTable(ModelMap model) throws ParseException {
		model.put("albums", service.read());
		return "index";
	}
	
	@PostMapping(value="/update")
	public String updateAlbum(ModelMap model, @RequestParam int id, @RequestParam String name, @RequestParam String artist, @RequestParam String price, 
			@RequestParam String release_date, @RequestParam String genre_name) throws ParseException {
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(release_date);
		service.update(id, name, artist, price, date, genre_name);
		model.put("message", "Album has been updated");
		return "index";
	}
	
	@PostMapping(value="/delete")
	public String deleteAlbum(ModelMap model, @RequestParam int id) {
		service.delete(id);
		model.put("message", "The album has been deleted");
		return "index";
	}
	
	@PostMapping(value="/search")
	public String searchAlbums(ModelMap model, @RequestParam String column, @RequestParam String value) throws ParseException {
		List<AlbumGenre> dis = service.search(column, value);
		for(AlbumGenre x : dis) {
			System.out.println(x.toString());
		}
		model.put("albums", service.search(column, value));
		return "index";
	}
	
	
	
}
