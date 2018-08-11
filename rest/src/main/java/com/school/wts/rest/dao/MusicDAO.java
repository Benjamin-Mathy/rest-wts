package com.school.wts.rest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.wts.rest.dao.mapper.MusicMapper;
import com.school.wts.rest.dto.MusicDTO;
import com.school.wts.rest.entity.Music;
import com.school.wts.rest.repository.MusicRepository;

/**
 * @author Youba
 *
 */
@Service
public class MusicDAO {
	@Autowired
	MusicRepository repository;
	
	public MusicDTO getByUid(Long uid) {
		Optional<Music> music = repository.findById(uid);
		if(music.isPresent()) {
			return MusicMapper.entityToDto(music.get());
		}
		else {
			return new MusicDTO(0L, "", "", "", "");
		}
	}
	
	public List<MusicDTO> findByTitleAndArtist(String title, String artist){
		List<MusicDTO> result = new ArrayList<>();
		List<Music> musics = repository.findByTitleAndArtist(title, artist);
		for (Music Music : musics) {
			result.add(MusicMapper.entityToDto(Music));
		}
		return result;
	}
	
	
	public MusicDTO createMusic(MusicDTO musicDTO) {
		Music response = repository.save(MusicMapper.dtoToEntity(musicDTO));		
		return MusicMapper.entityToDto(response);
	}
	
	
	public MusicDTO updateMusic(MusicDTO musicDTO) {
		Optional<Music> music = repository.findById(musicDTO.getId());
		Music newMusic = MusicMapper.dtoToEntity(musicDTO);
		if(music.isPresent()) {
			music.get().setTitle(newMusic.getTitle());
			music.get().setArtist(newMusic.getArtist());
			music.get().setGenre(newMusic.getGenre());
			music.get().setFilePath(newMusic.getFilePath());
			Music response = repository.save(music.get());
			return MusicMapper.entityToDto(response);
		}
		else {
			return new MusicDTO(0L, "", "", "", "");
		}
	}
	
	
	public void deleteMusic(Long uid) {
		repository.deleteById(uid);
	}
}
