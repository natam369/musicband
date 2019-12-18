package com.mindtree.kalingamusicband.service;

import java.util.List;

import com.mindtree.kalingamusicband.dto.SongDto;
import com.mindtree.kalingamusicband.exception.ServiceException;

public interface SongService {

	List<SongDto> getSong(int songId) throws ServiceException;

}
