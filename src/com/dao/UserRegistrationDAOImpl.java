package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bean.UserRegistration;

public class UserRegistrationDAOImpl implements UserRegistrationDAO {
	 static Connection con;
     static PreparedStatement ps;
     UserRegistration ur=new UserRegistration();

	@Override
	public int getuser(String name, String email, String pass, String repass) {
		int status=0;
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("INSERT INTO Customers VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, name );
			ps.setString(2, email);
			ps.setString(3, pass);
			ps.setString(4, repass);
			ps.setInt(5, 0);
			ps.setInt(6, 3);
			ps.setString(7, "user");
			if(pass.contentEquals(repass)) {
			status=ps.executeUpdate();
			System.out.println(name);
			System.out.println(status);
			
			    
			}
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return status;
	}

}
