package com.mindtree.kalingamusicband.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class AlbumDto {

	private int albumId;
	private String albumName;
	// @JsonIgnoreProperties("albumDto")
	private List<SongDto> songsDto;

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public List<SongDto> getSongsDto() {
		return songsDto;
	}

	public void setSongsDto(List<SongDto> songsDto) {
		this.songsDto = songsDto;
	}

	@Override
	public String toString() {
		return "AlbumDto [albumId=" + albumId + ", albumName=" + albumName + ", songsDto=" + songsDto + "]";
	}

	public AlbumDto(int albumId, String albumName, List<SongDto> songsDto) {
		super();
		this.albumId = albumId;
		this.albumName = albumName;
		this.songsDto = songsDto;
	}

	public AlbumDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
