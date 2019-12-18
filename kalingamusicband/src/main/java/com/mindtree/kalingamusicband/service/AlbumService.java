package com.mindtree.kalingamusicband.service;

import com.mindtree.kalingamusicband.dto.AlbumDto;
import com.mindtree.kalingamusicband.entities.Album;

public interface AlbumService {

	AlbumDto insertAlbum(Album album);

	int getSongsCount(int albumId);

}
