package com.web.store.music_store.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.AlbumGenre;
import com.web.store.music_store.repository.AlbumGenreRepository;

@Service
public class AlbumGenreService {

	@Autowired
	AlbumGenreRepository repo;
	
	public void create(AlbumGenre obj) {
		repo.save(obj);
	}
	
	public Iterable<AlbumGenre> read() throws ParseException{
		return repo.findAll();
	}
	
	public void update(int id, String name, String artist, String price, Date release_date, String genre_name) {
		AlbumGenre album = repo.findById(id).get();
		album.setName(genre_name);
		album.setArtist(artist);
		album.setPrice(price);
		album.setRelease_date(release_date);
		album.setGenre_name(genre_name);
		repo.save(album);
	}
	
	public void delete(int id) {
		repo.delete(repo.findById(id).get());
	}
	
	public List<AlbumGenre> search(String column, String value) throws ParseException {
		List<AlbumGenre> albums = (List<AlbumGenre>)repo.findAll();
		List<AlbumGenre> sortedAlbums;
		if(column.equals("name")) {
			sortedAlbums = albums.stream().filter(album->album.getName().equals(value)).collect(Collectors.toList()); 
		} else if(column.equals("artist")) {
			sortedAlbums = albums.stream().filter(album->album.getArtist().equals(value)).collect(Collectors.toList());
		} else {
			sortedAlbums = albums.stream().filter(album->album.getGenre_name().equals(value)).collect(Collectors.toList());
		}
		return sortedAlbums;
	}
	
}
