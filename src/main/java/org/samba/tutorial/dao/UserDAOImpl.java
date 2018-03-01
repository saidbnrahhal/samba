package org.samba.tutorial.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.samba.tutorial.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userDAO")
@Transactional(propagation=Propagation.REQUIRED)
public class UserDAOImpl implements UserDAO {
	
	
	@PersistenceContext
	public EntityManager entityManager;

	
	@Transactional(readOnly=false)
	public User addUser(User user) {
		entityManager.persist(user);
		return user;
	}
	
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		 List<User> users = new ArrayList<>();
		 Query query  = entityManager.createQuery("select user from User user");
		 users = query.getResultList();
		 return users ;
	}
}
