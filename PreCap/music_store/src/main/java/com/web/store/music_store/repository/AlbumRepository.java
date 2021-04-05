package com.web.store.music_store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.store.music_store.model.Album;


@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

}
