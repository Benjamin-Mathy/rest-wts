package com.school.wts.rest.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.school.wts.rest.entity.Music;

/**
 * @author Youba
 *
 */
public interface MusicRepository extends CrudRepository<Music, Long>{
	List<Music> findByTitleAndArtist(String title, String artist);
}
