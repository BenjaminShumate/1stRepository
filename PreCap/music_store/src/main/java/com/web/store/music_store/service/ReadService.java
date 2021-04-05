package com.web.store.music_store.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.Album;
import com.web.store.music_store.model.Genre;
import com.web.store.music_store.model.Music;
import com.web.store.music_store.repository.AlbumRepository;
import com.web.store.music_store.repository.GenreRepository;
import com.web.store.music_store.repository.MusicRepository;

//Ben coded this, if you want to ask about it
//This is a prototype service class that has two main functions
//The first set of functions will retrieve and return the entire table of respective object as an interable
//The second set of functions takes two input parameters
//These parameters are the "column" which represents a variable from an entity class and "value" which is the specific value a user is searching for.
//These, appropriately named, search functions will scour the respective list of all objects associated with an entity for entries that match the search criteria
@Service
public class ReadService {
	
	@Autowired
	AlbumRepository aRepository;
	@Autowired
	GenreRepository gRepository;
	@Autowired
	MusicRepository mRepository;
	
	public Iterable<Album> getAlbums(){
		return aRepository.findAll();
	}
	
	public Iterable<Genre> getGenres(){
		return gRepository.findAll();
	}
	
	public Iterable<Music> getMusic(){
		return mRepository.findAll();
	}
	
	public List<Album> searchAlbums(String column, String value) throws ParseException{
		List<Album> matchingAlbums = new ArrayList<Album>();
		Iterable<Album> albums = getAlbums();
		for(Album album : albums) {
			if(column.equals("id")) {
				if(album.getId() == Integer.parseInt(value)) matchingAlbums.add(album);
			} else if (column.equals("name")) {
				if(album.getName().equals(value)) matchingAlbums.add(album);
			} else if (column.equals("artist")) {
				if (album.getArtist().equals(value)) matchingAlbums.add(album);
			} else if (column.equals("release_date")) {
				if (album.getRelease_date().equals(new SimpleDateFormat("dd/MM/yyyy").parse(value))) matchingAlbums.add(album);
			} else {
				if (album.getGenre_id() == Integer.parseInt(value))matchingAlbums.add(album);
			}
		}
		return matchingAlbums;
	}
	
	public List<Genre> searchGenres(String column, String value){
		List<Genre> matchingGenres = new ArrayList<Genre>();
		Iterable<Genre> genres = getGenres();
		for(Genre genre : genres) {
			if(column.equals("id")) {
				if(genre.getId() == Integer.parseInt(value)) matchingGenres.add(genre);
			} else if (column.equals("name")) {
				if(genre.getName().equals(value)) matchingGenres.add(genre);
			} 
		}
		return matchingGenres;
	}
	
	public List<Music> searchMusic(String column, String value) throws ParseException{
		List<Music> matchingMusic = new ArrayList<Music>();
		Iterable<Music> music = getMusic();
		for(Music tMusic : music) {
			if(column.equals("id")) {
				if(tMusic.getId() == Integer.parseInt(value)) matchingMusic.add(tMusic);
			} else if (column.equals("name")) {
				if(tMusic.getName().equals(value)) matchingMusic.add(tMusic);
			} else if (column.equals("artist")) {
				if (tMusic.getPrice().equals(value)) matchingMusic.add(tMusic);
			} else if (column.equals("release_date")) {
				if (tMusic.getTrack_number() == Integer.parseInt(value)) matchingMusic.add(tMusic);
			} else {
				if (tMusic.getAlbum_id() == Integer.parseInt(value))matchingMusic.add(tMusic);
			}
		}
		return matchingMusic;
	}
}
