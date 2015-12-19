<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<title>My online store</title>
</head>

<%-- Main Login page --%>

<body>
	<h1>My online store</h1>
	<div id="mainContent">
		
		<h2>User login</h2>
		
		<div>
			<p>User and password have to be the same</p>
		</div>
		
		<form id="loginForm" action="login" method="post">

			<div>
				User: <span><input id="user" name="user" type="text" /></span>
			</div>

			<div>
				Password: <span><input id="password" name="password"
					type="password" /></span>
			</div>
			
			<br />
			
			<% if(request.getAttribute("loginError") != null) { %>
			<p style="color:red"><%= request.getAttribute("loginError") %></p>
			<br />
			<% } %>
			
			<div>
				<input id="loginButton" type="submit" value="Login" />
			</div>
		</form>
	</div>
	
</body>
</html>