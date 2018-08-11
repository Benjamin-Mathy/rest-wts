package com.school.wts.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Youba
 *
 */
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	// @Column(unique=true)
	private String login;
	private String password;
	private String email;
	private Integer active = 1;
	private String role = "USER";

	/**
	 * 
	 */
	private User() {
		super();
	}

	/**
	 * @param login
	 * @param password
	 * @param email
	 */
	public User(String login, String password, String email) {
		this();
		this.login = login;
		this.password = password;
		this.email = email;
	}

	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param email
	 */
	public User(Long id, String login, String password, String email) {
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
	 * @param active
	 * @param role
	 */
	public User(Long id, String login, String password, String email, Integer active, String role) {
		this();
		this.id = id;
		this.login = login;
		this.password = password;
		this.email = email;
		this.active = active;
		this.role = role;
	}

	/**
	 * @param id
	 * @param login
	 * @param password
	 * @param email
	 * @param role
	 */
	public User(Long id, String login, String password, String email, String role) {
		super();
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
	 * @return the active
	 */
	public Integer getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(Integer active) {
		this.active = active;
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

}
