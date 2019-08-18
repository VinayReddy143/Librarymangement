package com.dao;

import java.util.ArrayList;

import com.bean.UserDetails;

public interface UserDetailsDAO {
	
	public ArrayList<UserDetails> search(String userID);

}
