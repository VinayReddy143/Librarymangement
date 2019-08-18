package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DeleteBookDAO;
import com.dao.DeleteBookDAOImpl;


@WebServlet("/DeleteBookServer")
public class DeleteBookServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeleteBookDAO delete=new DeleteBookDAOImpl();
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String description=request.getParameter("description");
		int noofbooks=Integer.parseInt(request.getParameter("noofbooks"));
		int status=delete.deleteBook(title, author, description, noofbooks);
		if(status==1) {
			System.out.println(status);
			request.setAttribute("message","books deleted");
			request.getRequestDispatcher("DeleteBook.jsp").forward(request, response);
	}
		else
		{
			request.setAttribute("message","books not deleted");
		}
		
	}

}
