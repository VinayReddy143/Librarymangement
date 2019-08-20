package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateUserDAOImpl implements UpdateUserDAO {
	 static Connection con;
     static PreparedStatement ps;
     
	@Override
	public int limitcheck(String userid) {
		int limit=0;
		
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from customers where email=?");
			ps.setString(1, userid );
			ResultSet rsu=ps.executeQuery();
			while(rsu.next())
			{
				limit=rsu.getInt(6);
			}
		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return limit;
	}
	public int update(String title, String type,String userid) {
		int status=0;
		int finalStatus=0;
		int noofbooks=0;
		int usernoofbooks=0;
		int limit=0;
		
		try {
			
			
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from books where title=?");
			ps.setString(1, title );
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				noofbooks=rs.getInt(4);
			}
			ps=con.prepareStatement("select * from Customers where email=?");
			ps.setString(1,userid );
			ResultSet rs1=ps.executeQuery();
			while(rs1.next())
			{
				System.out.println("in  second resultset");
				System.out.println(usernoofbooks);
				usernoofbooks=rs1.getInt(5);
				System.out.println(usernoofbooks);
			}
			
			if(type.contentEquals("borrow"))
			{
				noofbooks=noofbooks-1;
			ps=con.prepareStatement("update books set noofbooks=? where title=?");
			ps.setInt(1,noofbooks );
			ps.setString(2, title );
			status=ps.executeUpdate();
			finalStatus=finalStatus+status;
			usernoofbooks=usernoofbooks+1;
			limit=3-usernoofbooks;
			ps=con.prepareStatement("update customers set noofbooks=?,books=?where email=?");
			ps.setInt(1,usernoofbooks );
			ps.setString(2, title);
			ps.setString(3,userid );
			
			status=ps.executeUpdate();
			finalStatus=finalStatus+status;
			ps=con.prepareStatement("update customers set remains=? where email=?");
			ps.setInt(1,limit );
			
			ps.setString(2,userid );
			status=ps.executeUpdate();
			finalStatus=finalStatus+status;
			ps=con.prepareStatement("update customers set books=? where email=?");
			ps.setString(1,title );
			
			ps.setString(2,userid );
			status=ps.executeUpdate();
			finalStatus=finalStatus+status;
			
			}
			else
			{
				noofbooks=noofbooks+1;
				ps=con.prepareStatement("update books set noofbooks=? where title=?");
				ps.setInt(1,noofbooks );
				ps.setString(2, title );
				status=ps.executeUpdate();
				finalStatus=finalStatus+status;
				usernoofbooks=usernoofbooks-1;
				limit=3-usernoofbooks;
				ps=con.prepareStatement("update Customers set noofbooks=? email=?");
				ps.setInt(1,usernoofbooks );
				
				ps.setString(2,userid );
				status=ps.executeUpdate();
				finalStatus=finalStatus+status;
				ps=con.prepareStatement("update customers set remains=? where email=?");
				ps.setInt(1,limit );
				
				ps.setString(2,userid );
				status=ps.executeUpdate();
				finalStatus=finalStatus+status;
				ps=con.prepareStatement("update customers set books=? where email=?");
				ps.setString(1,title );
				
				ps.setString(2,userid );
				status=ps.executeUpdate();
				finalStatus=finalStatus+status;
			}
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		System.out.println(finalStatus);
		
		return finalStatus;
	}

}
