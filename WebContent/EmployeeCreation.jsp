<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Style1css.css">
</head>
<body>




<form action="EmployeeServer" method="get">
<div class="searchbox">
<h1>Registration</h1>
<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null) {%>
<%=message %><%} %>

<table align = "center">
<tr>
<td>
<input  type = "text" placeholder="Name" name = "name"><br><br><br>
</td></tr>
<tr>
<td>
<input type = "text" placeholder="Email" name ="email"><br></br>
</td></tr>
<tr>
<td>
<input type = "password" placeholder="******" name ="pass"><br></br>
</td></tr>
<tr>
<td>
<input type = "password" placeholder="******" name ="repass"><br></br>
</td></tr>


<tr>
<td><input type ="submit" name="Register" value ="Register">
</table>
</div>
</form>


</body>
</html>