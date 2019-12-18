package com.mindtree.kalingamusicband.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.kalingamusicband.dto.AlbumDto;
import com.mindtree.kalingamusicband.entities.Album;
import com.mindtree.kalingamusicband.service.AlbumService;
import com.mindtree.kalingamusicband.service.ArtistService;
import com.mindtree.kalingamusicband.service.SongService;

@RestController
public class AlbumController {

	@Autowired
	AlbumService albumService;

	@Autowired
	ArtistService artistService;

	@Autowired
	SongService songService;

	@PostMapping("/addsong/")
	public AlbumDto addAlbum(@RequestBody Album album) {

		return albumService.insertAlbum(album);

	}
	
	@GetMapping("/getsongcount/{id}")
	public int getSongsCount(@PathVariable("id") int albumId)
	{
		return albumService.getSongsCount(albumId);
		
	}

}
