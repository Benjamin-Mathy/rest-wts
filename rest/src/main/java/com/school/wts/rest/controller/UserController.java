package com.school.wts.rest.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.wts.rest.business.UserBusiness;
import com.school.wts.rest.dto.UserDTO;

/**
 * @author Youba
 *
 */
@RestController
//@RequestMapping("/user")
public class UserController {

	private Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserBusiness userBusiness;

//	@PostMapping("/login")
//	public @ResponseBody ResponseEntity<UserDTO> login(@RequestBody String login, @RequestBody String password){		
//		return new ResponseEntity<>(userBusiness.login(login, password),HttpStatus.OK);
//	}

	@GetMapping("/admin/{id}")
	public @ResponseBody ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
		return new ResponseEntity<>(userBusiness.getByUid(id), HttpStatus.OK);
	}

	@PostMapping("/create")
	public @ResponseBody ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		return new ResponseEntity<>(userBusiness.createUser(user), HttpStatus.OK);
	}

	@PostMapping("/admin/update")
	public @ResponseBody ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
		return new ResponseEntity<>(userBusiness.updateUser(user), HttpStatus.OK);
	}

	@DeleteMapping("/admin/delete/{id}")
	public @ResponseBody ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
		userBusiness.deleteUser(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/test")
	public @ResponseBody ResponseEntity<String> test(){
		userBusiness.createUser(new UserDTO("admin","admin", "admin@gmail.com", "ADMIN"));
		userBusiness.createUser(new UserDTO("user", "user", "user@gmail.com", "USER"));
		return new ResponseEntity<>("test",HttpStatus.OK);
	}

	
	@SuppressWarnings("unused")
	private String getPasswordHashed(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());

			byte byteData[] = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			LOGGER.error("hash password failed");
			e.printStackTrace();
		}

		return password;
	}

}
