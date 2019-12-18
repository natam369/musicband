package com.mindtree.kalingamusicband.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class SongDto {
	private int songId;
	private String songName;

	// @JsonIgnoreProperties("songs")
	private AlbumDto albumDto;
	// @JsonIgnoreProperties("songss")
	private ArtistDto artistDto;

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

	public AlbumDto getAlbumDto() {
		return albumDto;
	}

	public void setAlbumDto(AlbumDto albumDto) {
		this.albumDto = albumDto;
	}

	public ArtistDto getArtistDto() {
		return artistDto;
	}

	public void setArtistDto(ArtistDto artistDto) {
		this.artistDto = artistDto;
	}

	@Override
	public String toString() {
		return "SongDto [songId=" + songId + ", songName=" + songName + ", albumDto=" + albumDto + ", artistDto="
				+ artistDto + "]";
	}

	public SongDto(int songId, String songName, AlbumDto albumDto, ArtistDto artistDto) {
		super();
		this.songId = songId;
		this.songName = songName;
		this.albumDto = albumDto;
		this.artistDto = artistDto;
	}

	public SongDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
