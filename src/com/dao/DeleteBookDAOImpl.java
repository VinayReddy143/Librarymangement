package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBookDAOImpl implements DeleteBookDAO {
	static Connection con;
    static PreparedStatement ps;
	@Override
	public int deleteBook(String title, String author, String description, int noofbooks) {
		int status=0;
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("delete from Books where title=?");
			ps.setString(1, title );
			
			status=ps.executeUpdate();
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return status;
	}

}
