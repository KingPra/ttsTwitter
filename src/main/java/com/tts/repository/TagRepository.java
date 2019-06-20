package com.tts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tts.model.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	Tag findByPhrase(String phrase);
}
