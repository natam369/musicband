package com.mindtree.kalingamusicband.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingamusicband.dto.AlbumDto;
import com.mindtree.kalingamusicband.dto.ArtistDto;
import com.mindtree.kalingamusicband.dto.SongDto;
import com.mindtree.kalingamusicband.entities.Album;
import com.mindtree.kalingamusicband.entities.Artist;
import com.mindtree.kalingamusicband.entities.Song;
import com.mindtree.kalingamusicband.repository.AlbumRepo;
import com.mindtree.kalingamusicband.repository.ArtistRepo;
import com.mindtree.kalingamusicband.repository.SongRepo;
import com.mindtree.kalingamusicband.service.AlbumService;

@Service
public class AlbumServiceImpl implements AlbumService {

	@Autowired
	AlbumRepo albumRepo;

	@Autowired
	SongRepo songRepo;

	@Autowired
	ArtistRepo artistRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public AlbumDto insertAlbum(Album album) {
		Artist artist = new Artist();
		List<Song> songs = album.getSongs();
		List<Song> newSongs = new ArrayList<Song>();
		List<Song> artistSongs = new ArrayList<Song>();
		for (Song song : songs) {
			song.setAlbum(album);
			artist = song.getArtist();
			artistSongs.add(song);
			artist.setSongss(artistSongs);
			newSongs.add(song);
		}
		album.setSongs(newSongs);
		Album albumEntity = albumRepo.saveAndFlush(album);
		AlbumDto albumDto = convertEntity(albumEntity);
		List<SongDto> songDtos = new ArrayList<SongDto>();
		for (Song song : albumEntity.getSongs()) {
			SongDto songDto = convertEntity(song);
			Artist artistEntity = song.getArtist();
			ArtistDto artistDto = convertEntity(artistEntity);
			songDto.setArtistDto(artistDto);
			songDtos.add(songDto);
		}
		albumDto.setSongsDto(songDtos);
		return albumDto;
	}

	public AlbumDto convertEntity(Album albumEntity) {
		return mapper.map(albumEntity, AlbumDto.class);
	}

	public SongDto convertEntity(Song songEntity) {
		return mapper.map(songEntity, SongDto.class);
	}

	public ArtistDto convertEntity(Artist artistEntity) {
		return mapper.map(artistEntity, ArtistDto.class);
	}

	@Override
	public int getSongsCount(int albumId) {
		// TODO Auto-generated method stub
		Album album = albumRepo.getOne(albumId);
		List<Song> songs = new ArrayList<Song>();
		for (Song song : album.getSongs()) {
			songs.add(song);
		}
		return songs.size();
	}
}
