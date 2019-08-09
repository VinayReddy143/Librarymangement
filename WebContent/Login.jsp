<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style.css">
</head>

<body>
<h1 align = "center">Library Managment System</h1>
<hr noshade>

<form action="LoginServer" method="post">
<div class="loginbox">
<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null) {%>
<%=message %><%} %>
<h1>Login</h1>

<table align = "center">
<tr>
<td>

<input  type = "text" placeholder="User Name" name = "userName"><br><br><br>
</td></tr>
<tr>
<td>

<input type = "password" placeholder="********" name ="pwd"><br></br>
</td></tr>
<tr>
<td><input type ="submit" name="Login" value ="LOGIN"></td>
<td><a href="Register.jsp">Register</a></td>
</table>
</div>
</form>
</body>

</html>