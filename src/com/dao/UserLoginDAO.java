package com.dao;

import com.bean.UserLogin;
public interface UserLoginDAO {
	
	public UserLogin getuser(String username,String password);

}
