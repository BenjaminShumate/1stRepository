package com.web.store.music_store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.web.store.music_store.service.*;
import com.web.store.music_store.model.*;

//Class modified by Ben, if you want to ask questions
//just a basic test to confirm service method and mapping capabilities
@Controller
public class HomeController {
	
	@Autowired
	ReadService readService;
	@Autowired
	CreateUpdateDeleteService cudService;
	
	@PostMapping(value="/readTables")
	public String viewTables(ModelMap model, @RequestParam String viewType) {
		System.out.println("You got here with viewType: "+viewType);
		if(viewType.equals("albums")) {
			Iterable<Album> albums = readService.getAlbums();
			for(Album x : albums) {
				System.out.println(x.toString());
			}
		} else if(viewType.equals("genres")) {
			Iterable<Genre> genres = readService.getGenres();
			for(Genre x : genres) {
				System.out.println(x.toString());
			}
		} else if (viewType.equals("music")){
			Iterable<Music> music = readService.getMusic();
			for(Music x : music) {
				System.out.println(x.toString());
			}
		}
		return "index";
	}
	
	@PostMapping(value="/delete")
	public String deleteObject(ModelMap model, @RequestParam String id, @RequestParam String viewType) {
		if(viewType.equals("albums")) {
			cudService.deleteAlbum(Integer.parseInt(id));
		} else if(viewType.equals("genres")) {
			cudService.deleteGenre(Integer.parseInt(id));
		} else if (viewType.equals("music")){
			cudService.deleteMusic(Integer.parseInt(id));
		}
		return "delete";
	}
}
