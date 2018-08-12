package com.school.wts.rest.wrapper;

import org.springframework.stereotype.Service;

import com.school.wts.rest.dto.MusicDTO;

/**
 * @author Youba
 *
 */
@Service
public class RecognizerWrapper {
	
	public MusicDTO recognizeMusic(MusicDTO music) {
		music.setArtist("artist");
		music.setGenre("genre");
		music.setTitle("title");
		return music;
	}

}
