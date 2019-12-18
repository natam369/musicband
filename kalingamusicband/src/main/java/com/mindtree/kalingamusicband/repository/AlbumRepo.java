package com.mindtree.kalingamusicband.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.kalingamusicband.entities.Album;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Integer>{

}
