package com.mahi.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mahi.rest.model.User;
/**
 * 
 * @author Mahendra
 * This interface makes use of JpaRepository
 * which will take care of the CRUD operations
 * on the transient objects
 * Hence, no need to implement CRUD operation explicitly
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
