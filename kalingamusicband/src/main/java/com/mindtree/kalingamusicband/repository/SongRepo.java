package com.mindtree.kalingamusicband.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingamusicband.entities.Song;

@Repository
public interface SongRepo extends JpaRepository<Song, Integer>{

}
