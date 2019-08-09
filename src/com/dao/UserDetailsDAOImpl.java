package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.bean.SearchBook;
import com.bean.UserDetails;

public class UserDetailsDAOImpl implements UserDetailsDAO {
	static Connection con;
    static PreparedStatement ps;
     UserDetails user=new UserDetails();
    ArrayList<UserDetails> userList = new ArrayList<UserDetails>();
	@Override
	public ArrayList<UserDetails> search(String userID) {
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from customers where email=?");
			ps.setString(1, userID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println("in users list");
				user.setName(rs.getString(1));
				user.setEmail(rs.getString(2));
				user.setNoofbooks(rs.getString(5));
				user.setLimit(rs.getString(6));
				userList.add(user);
			
				
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return userList;
	}

}
