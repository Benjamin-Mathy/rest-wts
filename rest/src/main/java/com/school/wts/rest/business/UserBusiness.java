package com.school.wts.rest.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.wts.rest.dao.UserDAO;
import com.school.wts.rest.dto.UserDTO;

/**
 * @author Youba
 *
 */
@Service
public class UserBusiness {
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserDTO getByUid(Long uid) {
		return userDAO.getByUid(uid).getUserWithoutPassword();
	}
	
	public UserDTO findByLogin(String login) {
		return userDAO.findByLogin(login).getUserWithoutPassword();
	}
	
	
	public UserDTO login(String login, String password){
		UserDTO userMatched = userDAO.findByLoginAndPassword(login, password);
		if(userMatched==null) {
			return new UserDTO(0L, "", "", "");
		}
		else {
			
			return userMatched.getUserWithoutPassword();
		}
	}
	
	
	public UserDTO createUser(UserDTO userDTO) {
		userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		return userDAO.createUser(userDTO).getUserWithoutPassword();
	}
	
	
	public UserDTO updateUser(UserDTO userDTO) {
		//userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		return userDAO.updateUser(userDTO).getUserWithoutPassword();
	}
	
	
	public void deleteUser(Long uid) {
		userDAO.deleteUser(uid);
	}
}
