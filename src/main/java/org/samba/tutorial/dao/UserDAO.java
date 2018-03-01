package org.samba.tutorial.dao;

import java.util.List;

import org.samba.tutorial.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public interface UserDAO {

	
	public User addUser(User user);
	public List<User> getAllUsers();
}
