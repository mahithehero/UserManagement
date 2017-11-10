package com.mahi.rest.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahi.rest.model.User;
import com.mahi.rest.repository.UserRepository;

/**
 * @author Mahendra
 * This service implementation class implements the CRUD operations
 * with the help of JPA repository functionality
 */
@Service
public class DefaultUserService implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User entity) {
		return userRepository.save(entity);
	}

	@Override
	public User getById(Serializable id) {
		return userRepository.findOne((Long) id);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		userRepository.delete((Long) id);
	}

}
