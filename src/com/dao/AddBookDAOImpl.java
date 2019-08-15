package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bean.AddBook;

public class AddBookDAOImpl implements AddBookDAO {
	 static Connection con;
     static PreparedStatement ps;
     AddBook add=new AddBook();
	@Override
	public int addBook(String title, String author, String description, int noofbooks) {
		int status=0;
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("INSERT INTO Books VALUES(?,?,?,?)");
			ps.setString(1, title );
			ps.setString(2, author);
			ps.setString(3, description);
			ps.setInt(4, noofbooks);
			status=ps.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return status;
	}

}
