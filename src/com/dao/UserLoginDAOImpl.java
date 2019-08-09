package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.UserLogin;

public class UserLoginDAOImpl implements UserLoginDAO {
      static Connection con;
      static PreparedStatement ps;
      UserLogin us=new UserLogin();
      
	@Override
	public UserLogin getuser(String username, String password) {
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from Customers where email=? and pass=?");
		
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(true);
			
				us.setUserid(rs.getString(1));
				us.setPassword(rs.getString(2));
				us.setType(rs.getString(7));
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return us;
	}

}
