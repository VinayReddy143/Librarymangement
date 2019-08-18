package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dao.UserRegistrationDAO;
import com.dao.UserRegistrationDAOImpl;


@WebServlet("/EmployeeServer")
public class EmployeeServer extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeDAO emp=new EmployeeDAOImpl();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		String repass=request.getParameter("repass");
		String card=request.getParameter("card");
		String register=request.getParameter("Register");
		int status=emp.getuser(name, email, pass, repass);
		System.out.println(name);
		if(status==1) {
			System.out.println(status);
			request.setAttribute("message","user created");
			
	}

}
}
