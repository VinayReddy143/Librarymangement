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
			ps=con.prepareStatement("select * from Customers where email like ? and pass like ?");
		
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				System.out.println(true);
				
			
				us.setUserid(rs.getString(2));
				us.setPassword(rs.getString(3));
				us.setType(rs.getString(7));
				us.setName(rs.getString(1));
				if(username.equals(us.getUserid())&& password.equals(us.getPassword()))
				{
					System.out.println("everything is fine");
				}
				else {
					us.setUserid(null);
					us.setPassword(null);
					us.setName(null);
					us.setType(null);
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return us;
	}

}
