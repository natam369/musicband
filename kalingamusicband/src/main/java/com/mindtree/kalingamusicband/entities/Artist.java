package com.mindtree.kalingamusicband.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Artist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int artistId;
	private String artistName;
	
	@OneToMany(mappedBy = "artist",cascade = CascadeType.ALL)
	private List<Song> songss;

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public List<Song> getSongss() {
		return songss;
	}

	public void setSongss(List<Song> songss) {
		this.songss = songss;
	}

	@Override
	public String toString() {
		return "Artist [artistId=" + artistId + ", artistName=" + artistName + ", songss=" + songss + "]";
	}

	public Artist(int artistId, String artistName, List<Song> songss) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.songss = songss;
	}

	public Artist() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
