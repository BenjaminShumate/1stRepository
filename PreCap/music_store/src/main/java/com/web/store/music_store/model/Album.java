package com.web.store.music_store.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {

	@Id
	private int id;
	
	private String name;
	
	private String artist;
	
	private String price;
	
	private Date release_date;
	
	private int genre_id;

	public Album() {
		super();
	}
	
	public Album(int id, String name, String artist, String price, Date release_date, int genre_id) {
		super();
		this.id = id;
		this.name = name;
		this.artist = artist;
		this.price = price;
		this.release_date = release_date;
		this.genre_id = genre_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Date getRelease_date() {
		return release_date;
	}

	public void setRelease_date(Date release_date) {
		this.release_date = release_date;
	}

	public int getGenre_id() {
		return genre_id;
	}

	public void setGenre_id(int genre_id) {
		this.genre_id = genre_id;
	}

	@Override
	public String toString() {
		return "Album [id=" + id + ", name=" + name + ", artist=" + artist + ", price=" + price + ", release_date="
				+ release_date + ", genre_id=" + genre_id + "]";
	}
	
	
	
	
}
