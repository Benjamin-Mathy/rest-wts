package com.school.wts.rest.dto;

/**
 * @author Youba
 *
 */
public class UserDTO {
	private Long id;
	private String login;
	private String password;
	private String email;
	private String role;

	/**
	 * 
	 */
	private UserDTO() {
		super();
	}

	/**
	 * @param login
	 * @param password
	 * @param email
	 */
	public UserDTO(String login, String password, String email) {
		this();
		this.login = login;
		this.password = password;
		this.email = email;
	}

	/**
	 * @param login
	 * @param password
	 * @param email
	 * @param role
	 */
	public UserDTO(String login, String password, String email, String role) {
		this();
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param email
	 */
	public UserDTO(Long id, String login, String password, String email) {
		this();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
	}

	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param email
	 * @param role
	 */
	public UserDTO(Long id, String login, String password, String email, String role) {
		this();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	
	
	public UserDTO getUserWithoutPassword() {
		this.password=null;
		return this;
	}

}
