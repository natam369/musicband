package com.mindtree.kalingamusicband.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int songId;

	private String songName;

	@ManyToOne(cascade = CascadeType.ALL)
	private Album album;

	@ManyToOne(cascade = CascadeType.ALL)
	private Artist artist;

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "Song [songId=" + songId + ", songName=" + songName + ", album=" + album + ", artist=" + artist + "]";
	}

	public Song(int songId, String songName, Album album, Artist artist) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.album = album;
		this.artist = artist;
	}

	public Song() {
		super();
		// TODO Auto-generated constructor stub
	}

}
