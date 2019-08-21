<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="Style1css.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="deletebox">
<h1>Updation</h1>
<form action="UpdateServer" method="get">

<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null) {%>
<%=message %><%} %>

<table align = "center">
<tr>
<td>
<input  type = "userid" placeholder="User ID" name = "userid"><br><br><br>
</td></tr>

<tr>
<td>
<input  type = "text" placeholder="Title of the book" name = "title"><br><br><br>
</td></tr>
<tr>

<tr>
<td>
<input type="radio" name="type" value="borrow"> Borrow<br>
<input type="radio" name="type" value="return"> Return<br><br></br>
</td></tr>


<tr>
<td><input type ="submit" name="update" value ="update">
</table></form>
</div>
</body>
</html>