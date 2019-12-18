package com.mindtree.kalingamusicband.service.impl;

import java.util.ArrayList;
import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.kalingamusicband.dto.AlbumDto;
import com.mindtree.kalingamusicband.dto.ArtistDto;
import com.mindtree.kalingamusicband.dto.SongDto;
import com.mindtree.kalingamusicband.entities.Album;
import com.mindtree.kalingamusicband.entities.Artist;
import com.mindtree.kalingamusicband.entities.Song;
import com.mindtree.kalingamusicband.exception.ServiceException;
import com.mindtree.kalingamusicband.exception.util.ErrorConstants;
import com.mindtree.kalingamusicband.repository.AlbumRepo;
import com.mindtree.kalingamusicband.repository.ArtistRepo;
import com.mindtree.kalingamusicband.repository.SongRepo;
import com.mindtree.kalingamusicband.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	AlbumRepo albumRepo;

	@Autowired
	SongRepo songRepo;

	@Autowired
	ArtistRepo artistRepo;

	ModelMapper mapper = new ModelMapper();

	@Override
	public List<SongDto> getSong(int songId) throws ServiceException {
		Song song = songRepo.getOne(songId);
		String artistName = song.getArtist().getArtistName();
		List<Song> songs = songRepo.findAll();
		List<Song> artistSongs = new ArrayList<Song>();
		for (Song song2 : songs) {
			if (song2.getArtist().getArtistName().equalsIgnoreCase(artistName)) {
				artistSongs.add(song2);
			}
		}
		if(artistSongs.size()==0)
		{
			throw new ServiceException(ErrorConstants.NOSONG);
		}
		List<SongDto> songDtos = new ArrayList<SongDto>();
		for (Song song2 : artistSongs) {
			SongDto sdto = convertEntity(song2);
			Artist artistEntity = song2.getArtist();
			ArtistDto artistDto = convertEntity(artistEntity);
			sdto.setArtistDto(artistDto);
			songDtos.add(sdto);
		}
		//songDtos=artistSongs.stream().map(e->convertEntity(e)).collect(Collectors.toList());
		return songDtos;
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
}
