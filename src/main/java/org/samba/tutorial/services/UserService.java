package org.samba.tutorial.services;

import java.util.List;

import org.samba.tutorial.services.bean.UserBean;


public interface UserService {
	
	public UserBean addUser(UserBean userBean);
	
	public List<UserBean> getAllUsers();

}
