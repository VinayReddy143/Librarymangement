package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AddBookDAO;
import com.dao.AddBookDAOImpl;


@WebServlet("/AddBookServer")
public class AddBookServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddBookDAO add=new AddBookDAOImpl();
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String description=request.getParameter("description");
		int noofbooks=Integer.parseInt(request.getParameter("noofbooks"));
		int status=add.addBook(title, author, description, noofbooks);
		if(status==1) {
			System.out.println(status);
			request.setAttribute("message","books added");
			request.getRequestDispatcher("AddBook.jsp").forward(request, response);
	}
		else
		{
			request.setAttribute("message","books not added");
		}

}
}
