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
<div class="deletebox">
<h1>Deletion</h1>

<form action="DeleteBookServer" method="get">

<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null) {%>
<%=message %><%} %>

<table align = "center">
<tr>
<td>
<input  type = "text" placeholder="Title of the book" name = "title"><br></br>
</td></tr>
<tr>
<td>
<input type = "text" placeholder="Author" name ="author"><br></br>
</td></tr>
<tr>
<td>
<input type = "text" placeholder="Description" name ="description"><br></br>
</td></tr>
<tr>
<td>
<input type = "text" placeholder="Number of books" name ="noofbooks"><br></br>
</td></tr>


<tr>
<td><input type ="submit" name="Delete" value ="Delete">
</table></form>
</div>
</body>
</html>