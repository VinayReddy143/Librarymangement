package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.SearchBook;

public class SearchBookDAOImpl implements SearchBookDAO {
	static Connection con;
    static PreparedStatement ps;
    
    ArrayList<SearchBook> searchBookList = new ArrayList<SearchBook>();
	@Override
	public ArrayList<SearchBook> search(String title, String author) {
		try {
			con=DatabaseUtil.getConnection();
			ps=con.prepareStatement("select * from Books where title=? or author=?");
			ps.setString(1, title);
			ps.setString(2, author);
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				
				
				SearchBook searchBook=new SearchBook();
				searchBook.setTitle(rs.getString(1));
				searchBook.setAuthor(rs.getString(2));
				searchBook.setDescription(rs.getString(3));
				searchBook.setNoofbooks(rs.getInt(4));
				System.out.println(searchBook.getTitle());
				searchBookList.add(searchBook);
				
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return searchBookList;
		
		
		
		
	}

}
