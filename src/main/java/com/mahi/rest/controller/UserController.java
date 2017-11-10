package com.mahi.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mahi.rest.model.User;
import com.mahi.rest.service.UserService;

/**
 * @author Mahendra
 * Controller class which handles the HTTP methods
 * This class handles the user management
 * User creation, updation, deletion and retrieve all users operations can be performed
 */

@RestController
@RequestMapping("/users")
public class UserController {

	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;
	
	// Service method which handles POST requests and creates new users
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User User) {
		userService.save(User);
		logger.debug("Added:: " + User);
		return new ResponseEntity<User>(User, HttpStatus.CREATED);
	}
	
	// Service method which handles PUT requests and updates existing users data based on the user id
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody User User) {
		User existingEmp = userService.getById(User.getId());
		if (existingEmp == null) {
			logger.debug("User with id " + User.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.save(User);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	// Service method which handles GET requests and fetches particular user data based on the user id
	@RequestMapping(value = "/userid/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User User = userService.getById(id);
		if (User == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found User:: " + User);
		return new ResponseEntity<User>(User, HttpStatus.OK);
	}

	// Service method which handles GET requests and fetches all existing users data
	@RequestMapping(value = "getallusers", method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> Users = userService.getAll();
		if (Users.isEmpty()) {
			logger.debug("Users does not exists");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + Users.size() + " Users");
		logger.debug(Arrays.toString(Users.toArray()));
		return new ResponseEntity<List<User>>(Users, HttpStatus.OK);
	}

	// Service method which handles DELETE requests and deletes a particular user data based on the user id
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		User User = userService.getById(id);
		if (User == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(id);
			logger.debug("User with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}
}