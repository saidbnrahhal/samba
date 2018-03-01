package org.samba.tutorial.services.converter;

import org.samba.tutorial.entity.User;
import org.samba.tutorial.services.bean.UserBean;

public class UserBeanConverter {

	public static User userBeanToUserEntity(UserBean userBean){
		User user = new  User();
		user.setFirstName(userBean.getFirstName());
		user.setLastName(userBean.getLastName());
		user.setEmail(userBean.getEmail());
		user.setPassword(userBean.getPassword());
		user.setSex(userBean.getSex());
		return user;
	}
	
	public static UserBean userEntityToUserBean(User userEntity){
		UserBean userBean = new  UserBean();
		userBean.setFirstName(userEntity.getFirstName());
		userBean.setLastName(userEntity.getLastName());
		userBean.setEmail(userEntity.getEmail());
		userBean.setPassword(userEntity.getPassword());
		userBean.setSex(userEntity.getSex());
		return userBean;
	}
	
	
	
}
