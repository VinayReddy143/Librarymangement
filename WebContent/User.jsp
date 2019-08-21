<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="Style.css">
		<style type="text/css">
			.enclose {
				width: 100%;
			}
			.aside {
				display: inline-block;
				vertical-align: top;
				width: 20%;
			}
			.iframe {
				display: inline-block;
				width: 80%;
			}
			.logo {
				padding: 20px 0px;
			}
			.logo-img {
				display: inline-block;
				vertical-align: middle;
				width: 15%;
			}
			.logo-text {
				display: inline-block;
				width: 85%;
				text-align: center;
				vertical-align: middle;
				font-size: 36px;
				padding: 50px 0px;
    			background-color: grey;
			}
			.logo-image {
				width: 100%;
			}
			.nav {
			    text-align: center;
			    display: flex;
			    padding: 30px 0px;
			    align-items: center;
			    justify-content: space-around;
			    border: 1px solid grey;
			}
			iframe {
				background-image: url(img.png);
			}
			.aside-div {
				padding: 10px 20px;
				border: 1px solid grey;
			}
		</style>
	</head>
	<body>
	<%response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate"); %>
		<div>
			<div class='logo'>
				<span class="logo-img"><img src="Libraryicon.png" alt="logo" height="140px" class="logo-image"></span><!--
				--><span class="logo-text">LIBRARY MANAGEMENT SYSTEM
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<%String message = (String)request.getAttribute("message"); %>
<%if(message!=null) {%>
<%=message %><%} %>&nbsp;&nbsp;
<a href="Login.jsp">Logout</a>
</span>
			
		<div>
			<div class="aside">
				
				<div class="aside-div">
					<a href="UserDetails.jsp" target="iframe_c">User Details</a>
				</div>
				<div class="aside-div">
					<a href="Search.jsp" target="iframe_c">Search Book</a>
				</div>
				
			</div><!--
			--><div class="iframe">
				<iframe height="450px" width="100%" name="iframe_c"><div><img src="pexels-photo-1166657.jpeg"></div></iframe>
			</div>
		</div>
	</body>
	</html>