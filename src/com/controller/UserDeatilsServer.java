package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SearchBook;
import com.bean.UserDetails;
import com.dao.UserDetailsDAO;
import com.dao.UserDetailsDAOImpl;


@WebServlet("/UserDeatilsServer")
public class UserDeatilsServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				UserDetailsDAO userDetails=new UserDetailsDAOImpl();
				UserDetails user=new UserDetails();
				ArrayList<UserDetails> userDetailsList = new ArrayList<UserDetails>();
				PrintWriter out =response.getWriter();
				String userid=request.getParameter("username");
				
				out.print("<table><tr><th>User Name</th><th>email</th><th>no of books</th><th>limit</th></tr>");
				userDetailsList=userDetails.search(userid);
				for(int i=0;i<userDetailsList.size();i++)
				{
					out.print("<tr><td>");
					
					user=userDetailsList.get(i);
					out.println(user.getName());
					out.print("</td>");
					out.print("<td>");
					out.println(user.getEmail());
					out.print("</td>");
					out.print("<td>");
					out.println(user.getNoofbooks());
					out.print("</td>");
					out.print("<td>");
					out.println(user.getLimit());
					out.print("</td>");
					out.print("</tr>");
					
				}
			}

			
		}
	

	
	


