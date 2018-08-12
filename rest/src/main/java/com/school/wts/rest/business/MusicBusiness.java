package com.school.wts.rest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.wts.rest.dao.MusicDAO;
import com.school.wts.rest.dto.MusicDTO;
import com.school.wts.rest.wrapper.DriveWrapper;
import com.school.wts.rest.wrapper.RecognizerWrapper;

/**
 * @author Youba
 *
 */
@Service
public class MusicBusiness {
	@Autowired
	private MusicDAO musicDAO;
	
	@Autowired
	private RecognizerWrapper recognizerWrapper;
	
	@Autowired
	private DriveWrapper driveWrapper;
	
	public MusicDTO getByUid(Long uid) {
		MusicDTO music = musicDAO.getByUid(uid);
		music.setFile(driveWrapper.getFile(music.getFileDriveID()));
		return music;
	}
	
	public List<MusicDTO> search(String title, String artist){
		return musicDAO.findByTitleAndArtist(title, artist);
	}	
	
	public MusicDTO createMusic(MusicDTO musicDTO) {
		musicDTO.setFileDriveID(driveWrapper.saveFile(musicDTO.getFile()));
		return musicDAO.createMusic(musicDTO);
	}	
	
	public MusicDTO updateMusic(MusicDTO musicDTO) {
		return musicDAO.updateMusic(musicDTO);
	}	
	
	public void deleteMusic(Long uid) {
		musicDAO.deleteMusic(uid);
	}
	
	public MusicDTO recognizeMusic(Long uid) {
		return musicDAO.updateMusic(recognizerWrapper.recognizeMusic(musicDAO.getByUid(uid)));
	}
}
