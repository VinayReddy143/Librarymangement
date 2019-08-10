package com.dao;

import com.bean.UserRegistration;

public interface UserRegistrationDAO {

	public int getuser(String name,String email,String pass,String repass);
}
