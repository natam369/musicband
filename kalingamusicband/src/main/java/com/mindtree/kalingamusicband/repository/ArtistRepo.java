package com.mindtree.kalingamusicband.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingamusicband.entities.Artist;
import com.mindtree.kalingamusicband.entities.Song;

@Repository
public interface ArtistRepo extends JpaRepository<Artist, Integer>{

	List<Artist> findAllByArtistName(String artistName);

}
