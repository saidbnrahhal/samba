package org.samba.tutorial.services;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.samba.tutorial.dao.UserDAO;
import org.samba.tutorial.entity.User;
import org.samba.tutorial.services.bean.UserBean;
import org.samba.tutorial.services.converter.UserBeanConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Transactional(propagation=Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	
	@Autowired(required=true)
	private UserDAO userDAO;

	public User addUser(String firstName,String lastName,String email,String sex,String password) {
		
		User user = new User();
		user.setCreateDate(new Date());
		user.setUpdatedDate(new Date());
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setSex(sex);
		user.setPassword(password);
		
		return userDAO.addUser(user);
	}

	@Override
	public UserBean addUser(UserBean userBean) {
		User user = UserBeanConverter.userBeanToUserEntity(userBean);
		User adduser = userDAO.addUser(user);
		UserBean addUserBean = UserBeanConverter.userEntityToUserBean(adduser);
		return addUserBean;
	}

	@Override
	public List<UserBean> getAllUsers() {
		List<UserBean> userBeans = new  ArrayList<>();
		List<User> users = userDAO.getAllUsers();
		for(User user : users){
			UserBean userBean = UserBeanConverter.userEntityToUserBean(user);
			userBeans.add(userBean);
		}
		return userBeans;
	}


}
