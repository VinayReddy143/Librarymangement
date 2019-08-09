package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserLogin;
import com.dao.UserLoginDAO;
import com.dao.UserLoginDAOImpl;

/**
 * Servlet implementation class LoginServer
 */
@WebServlet("/LoginServer")
public class LoginServer extends HttpServlet {
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName=request.getParameter("userName");
		String password=request.getParameter("pwd");
		String submit=request.getParameter("Login");
		
		
		
	
		
		UserLoginDAO user=new UserLoginDAOImpl();
		UserLogin username=new UserLogin();
		
		username=user.getuser(userName, password);
		System.out.println(username.getUserid());
		if(submit.contentEquals("LOGIN")&& username.getUserid()!=null) 
		{
			if(username.getType().contentEquals("emp"))
			{
			System.out.println("1");
			request.setAttribute("message","valid");
			request.getRequestDispatcher("Home.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("message","valid");
				request.getRequestDispatcher("User.jsp").forward(request, response);
				
			}
		}
		else if(submit.contentEquals("LOGIN"))
		{
			request.setAttribute("message","not valid");
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("Register.jsp").forward(request, response);
		}
		
		}

	}
	

