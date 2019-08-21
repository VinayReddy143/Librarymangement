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
<div class="Searchbox">
<h1>Search</h1>
<form action="SearchBookServer" method="get">

<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null) {%>
<%=message %><%} %>

<table align = "center">
<tr>
<td>
<input  type = "text" placeholder="Title of the book" name = "title"><br><br><br>
</td></tr>
<tr>
<td>
<input type = "text" placeholder="Author" name ="author"><br></br>
</td></tr>

<td><input type ="submit" name="Search" value ="Search">
</table></form>
</div>

</body>
</html>