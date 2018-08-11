package com.school.wts.rest.repository;

import org.springframework.data.repository.CrudRepository;

import com.school.wts.rest.entity.User;

/**
 * @author Youba
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	User findByLogin(String login);
	User findByLoginAndPassword(String login, String password);
}
