package com.school.wts.rest.dao.mapper;

import com.school.wts.rest.dto.UserDTO;
import com.school.wts.rest.entity.User;

/**
 * @author Youba
 *
 */
public class UserMapper {
	
	/**
	 * Constructor for block initialization of the class 
	 */
	private UserMapper() {
		
	}
	
	public static UserDTO entityToDto(User user) {
		return new UserDTO(user.getId(), user.getLogin(), user.getPassword(), user.getEmail(),user.getRole());
	}
	
	public static User dtoToEntity(UserDTO userDto) {
		return new User(userDto.getId(), userDto.getLogin(), userDto.getPassword(), userDto.getEmail(),userDto.getRole());
	}

}
