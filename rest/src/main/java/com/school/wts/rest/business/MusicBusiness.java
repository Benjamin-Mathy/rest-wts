package com.school.wts.rest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.wts.rest.dao.MusicDAO;
import com.school.wts.rest.dto.MusicDTO;

/**
 * @author Youba
 *
 */
@Service
public class MusicBusiness {
	@Autowired
	MusicDAO musicDAO;
	
	public MusicDTO getByUid(Long uid) {
		return musicDAO.getByUid(uid);
	}
	
	public List<MusicDTO> login(String title, String artist){
		return musicDAO.findByTitleAndArtist(title, artist);
	}	
	
	public MusicDTO createMusic(MusicDTO musicDTO) {
		return musicDAO.createMusic(musicDTO);
	}	
	
	public MusicDTO updateMusic(MusicDTO musicDTO) {
		return musicDAO.updateMusic(musicDTO);
	}	
	
	public void deleteMusic(Long uid) {
		musicDAO.deleteMusic(uid);
	}
}
