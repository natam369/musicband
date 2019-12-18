package com.mindtree.kalingamusicband.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingamusicband.dto.SongDto;
import com.mindtree.kalingamusicband.exception.ApplicationException;
import com.mindtree.kalingamusicband.exception.ServiceException;
import com.mindtree.kalingamusicband.service.AlbumService;
import com.mindtree.kalingamusicband.service.ArtistService;
import com.mindtree.kalingamusicband.service.SongService;

@RestController
public class SongController {

	@Autowired
	AlbumService albumService;
	
	@Autowired
	ArtistService artistService;
	
	@Autowired
	SongService songService;
	
	@GetMapping("/getsong/{id}")
	public List<SongDto> getSong(@PathVariable("id") int songId) throws ApplicationException 
	{
		try {
			return songService.getSong(songId);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
		 throw new ApplicationException(e.getMessage());
		}
		
	}
	
	
}
