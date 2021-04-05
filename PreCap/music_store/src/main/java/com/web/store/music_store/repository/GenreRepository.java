package com.web.store.music_store.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.web.store.music_store.model.Genre;


@Repository
public interface GenreRepository extends CrudRepository<Genre, Integer>{

}
