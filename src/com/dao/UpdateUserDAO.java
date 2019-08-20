package com.dao;

public interface UpdateUserDAO {
	public int limitcheck(String userid);
	public int update(String title,String type,String userid);
	

}
