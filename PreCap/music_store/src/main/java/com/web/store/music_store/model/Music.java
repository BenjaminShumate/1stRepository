package com.web.store.music_store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Music {

	@Id
	private int id;
	
	private String name;
	
	private String price;
	
	private int track_number;
	
	private int album_id;
	
	

	public Music() {
		super();
	}

	public Music(int id, String name, String price, int track_number, int album_id) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.track_number = track_number;
		this.album_id = album_id;
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

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public int getTrack_number() {
		return track_number;
	}

	public void setTrack_number(int track_number) {
		this.track_number = track_number;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}
	
}
