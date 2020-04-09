package com.cubic.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cubic.model.User;


@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	 User findUserByUsername(String username);

}
