package org.samba.tutorial.rest.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.samba.tutorial.services.UserService;
import org.samba.tutorial.services.bean.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Path("/user")
public class UserRestResource {

	
	@Autowired(required=true)
	@Qualifier("userService")
	private UserService userService;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/addUser")
	public UserBean addUser(UserBean userBean){
		UserBean addUser = userService.addUser(userBean);
		return addUser;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAllUsers")
	public List<UserBean> getAllUsers(){
		List<UserBean>  userBeans=userService.getAllUsers();
		return userBeans;
	}
	
	
}
