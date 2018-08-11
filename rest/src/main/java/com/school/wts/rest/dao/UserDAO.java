package com.school.wts.rest.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.wts.rest.dao.mapper.UserMapper;
import com.school.wts.rest.dto.UserDTO;
import com.school.wts.rest.entity.User;
import com.school.wts.rest.repository.UserRepository;

/**
 * @author Youba
 *
 */
@Service
public class UserDAO {
	
	@Autowired
	UserRepository repository;
	
	public UserDTO getByUid(Long uid) {
		Optional<User> user = repository.findById(uid);
		if(user.isPresent()) {
			return UserMapper.entityToDto(user.get());
		}
		else {
			return new UserDTO(0L, "", "", "");
		}
	}
	
	public UserDTO findByLogin(String login) {
//		List<UserDTO> result = new ArrayList<>();
//		List<User> users = repository.findByLogin(login);
//		for (User user : users) {
//			result.add(UserMapper.entityToDto(user));
//		}
//		return result.get(0);
		return UserMapper.entityToDto(repository.findByLogin(login));
	}
	
	
	public UserDTO findByLoginAndPassword(String login, String password){
//		List<UserDTO> result = new ArrayList<>();
//		List<User> users = repository.findByLoginAndPassword(login, password);
//		for (User user : users) {
//			result.add(UserMapper.entityToDto(user));
//		}
//		return result;
		
		return UserMapper.entityToDto(repository.findByLoginAndPassword(login, password));
	}
	
	
	public UserDTO createUser(UserDTO userDTO) {
		User response = repository.save(UserMapper.dtoToEntity(userDTO));		
		return UserMapper.entityToDto(response);
	}
	
	
	public UserDTO updateUser(UserDTO userDTO) {
		Optional<User> user = repository.findById(userDTO.getId());
		User newUser = UserMapper.dtoToEntity(userDTO);
		if(user.isPresent()) {
			user.get().setLogin(newUser.getLogin());
			user.get().setPassword(newUser.getPassword());
			user.get().setEmail(newUser.getEmail());
			User response = repository.save(user.get());
			return UserMapper.entityToDto(response);
		}
		else {
			return new UserDTO(0L, "", "", "");
		}
	}
	
	
	public void deleteUser(Long uid) {
		repository.deleteById(uid);
	}
}
