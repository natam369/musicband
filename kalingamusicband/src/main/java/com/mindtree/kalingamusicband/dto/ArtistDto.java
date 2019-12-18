package com.mindtree.kalingamusicband.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class ArtistDto {
	private int artistId;
	private String artistName;
	// @JsonIgnoreProperties("artistDto")
	private List<SongDto> songssDto;

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

	public List<SongDto> getSongssDto() {
		return songssDto;
	}

	public void setSongssDto(List<SongDto> songssDto) {
		this.songssDto = songssDto;
	}

	@Override
	public String toString() {
		return "ArtistDto [artistId=" + artistId + ", artistName=" + artistName + ", songssDto=" + songssDto + "]";
	}

	public ArtistDto(int artistId, String artistName, List<SongDto> songssDto) {
		super();
		this.artistId = artistId;
		this.artistName = artistName;
		this.songssDto = songssDto;
	}

	public ArtistDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
