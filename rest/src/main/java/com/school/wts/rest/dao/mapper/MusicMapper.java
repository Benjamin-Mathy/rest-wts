package com.school.wts.rest.dao.mapper;

import com.school.wts.rest.dto.MusicDTO;
import com.school.wts.rest.entity.Music;

/**
 * @author Youba
 *
 */
public class MusicMapper {
	/**
	 * Constructor for block initialization of the class 
	 */
	private MusicMapper() {
		
	}
	
	public static MusicDTO entityToDto(Music music) {
		return new MusicDTO(music.getId(), music.getTitle(), music.getArtist(), music.getGenre(), music.getFileDriveID());
	}
	
	public static Music dtoToEntity(MusicDTO musicDTO) {
		return new Music(musicDTO.getId(), musicDTO.getTitle(), musicDTO.getArtist(), musicDTO.getGenre(), musicDTO.getFileDriveID());
	}


}
