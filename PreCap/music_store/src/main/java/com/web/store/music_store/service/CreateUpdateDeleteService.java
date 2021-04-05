package com.web.store.music_store.service;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.store.music_store.model.Album;
import com.web.store.music_store.model.Genre;
import com.web.store.music_store.model.Music;
import com.web.store.music_store.repository.AlbumRepository;
import com.web.store.music_store.repository.GenreRepository;
import com.web.store.music_store.repository.MusicRepository;

@Service
public class CreateUpdateDeleteService {

	@Autowired
	AlbumRepository aRepository;
	@Autowired
	GenreRepository gRepository;
	@Autowired
	MusicRepository mRepository;
	
	public void createAlbum(int id, String name, String artist, String price, Date release_date, int genre_id) {
		Album album = new Album(id, name, artist, price, release_date, genre_id);
		aRepository.save(album);
	}
	
	public void createGenre(int id, String name) {
		Genre genre = new Genre(id, name);
		gRepository.save(genre);
	}
	
	public void createMusic(int id, String name, String price, int track_number, int album_id) {
		Music music = new Music(id, name, price, track_number, album_id);
		mRepository.save(music);
	}
	
	public void editAlbum(int id, String name, String artist, String price, Date release_date, int genre_id) {
		Album album = aRepository.findById(id).get();
		album.setId(id);
		album.setName(name);
		album.setArtist(artist);
		album.setPrice(price);
		album.setRelease_date(release_date);
		album.setGenre_id(genre_id);
		aRepository.save(album);
	}
	
	public void editGenre(int id, String name) {
		Genre genre = gRepository.findById(id).get();
		genre.setId(id);
		genre.setName(name);
		gRepository.save(genre);
	}
	
	public void editMusic(int id, String name, String price, int track_number, int album_id) {
		Music music = mRepository.findById(id).get();
		music.setId(id);
		music.setName(name);
		music.setPrice(price);
		music.setTrack_number(track_number);
		music.setAlbum_id(album_id);
		mRepository.save(music);
	}
	
	public void deleteAlbum(int id) {
		Album album = aRepository.findById(id).get();
		aRepository.delete(album);
	}
	
	public void deleteGenre(int id) {
		Genre genre = gRepository.findById(id).get();
		gRepository.delete(genre);
	}
	
	public void deleteMusic(int id) {
		Music music = mRepository.findById(id).get();
		mRepository.delete(music);
	}
	
	
	
}
