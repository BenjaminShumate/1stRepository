package com.web.store.music_store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.store.music_store.model.Music;

@Repository
public interface MusicRepository extends CrudRepository<Music, Integer>{

}
