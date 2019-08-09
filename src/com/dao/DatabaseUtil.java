package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	//String databaseURL = "jdbc:mysql://localhost:3306/librarydb?autoReconnect=true&useSSL=false";
   // String user = "root";
   // String password = "ASDFjkl@1";
   static Connection conn = null;
    public static Connection getConnection()
    {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        //conn = DriverManager.getConnection(databaseURL, user, password);
    }
        catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  try {
			 // conn = DriverManager.getConnection(databaseURL, user, password);
			  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb?autoReconnect=true&useSSL=false", "root", "ASDFjkl@1");
			// TODO Auto-generated catch block
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  return conn;
	  
    }
  public static void closeConnection()
  {
	  if(conn!=null)
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
