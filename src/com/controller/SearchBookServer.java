package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SearchBook;
import com.dao.SearchBookDAO;
import com.dao.SearchBookDAOImpl;


@WebServlet("/SearchBookServer")
public class SearchBookServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SearchBookDAO search=new SearchBookDAOImpl();
		SearchBook searchbook = new SearchBook();
		ArrayList<SearchBook> searchBookList = new ArrayList<SearchBook>();
		PrintWriter out =response.getWriter();
		String title=request.getParameter("title");
		String author =request.getParameter("author");
		out.print("<table border=10px><tr><th>Title</th><th>Author</th><th>Description</th><th>No of Books</th></tr>");
		searchBookList=search.search(title, author);
		for(int i=0;i<searchBookList.size();i++)
		{
			out.print("<tr><td>");
			System.out.println(searchBookList.get(0).getTitle());
			System.out.println(searchBookList.get(1).getTitle());
			searchbook=searchBookList.get(i);
			out.println(searchbook.getTitle());
			out.print("</td>");
			out.print("<td>");
			out.println(searchbook.getAuthor());
			out.print("</td>");
			out.print("<td>");
			out.println(searchbook.getDescription());
			out.print("</td>");
			out.print("<td>");
			out.println(searchbook.getNoofbooks());
			out.print("</td>");
			out.print("</tr>");
			
			
			
		}
		 
		out.print("</table>");
	}

}
