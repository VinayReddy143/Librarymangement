package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UpdateUserDAO;
import com.dao.UpdateUserDAOImpl;

@WebServlet("/UpdateServer")
public class UpdateServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UpdateUserDAO update=new UpdateUserDAOImpl();
	
	String userid=request.getParameter("userid");
	String title=request.getParameter("title");
	String type=request.getParameter("type");
	int limit=update.limitcheck(userid);
	if(limit>=0&&limit<=3)
	{
	int stauts=update.update(title, type,userid);
	if(stauts==4) {
		System.out.println(stauts);
		request.setAttribute("message","books updated");
		request.getRequestDispatcher("UpdateUser.jsp").forward(request, response);
     }
	else
	{
		request.setAttribute("message","books not updated");
	}
	}
	}

	

}
