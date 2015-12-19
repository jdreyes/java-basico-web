<%@page import="java.util.Date"%>
<%@ page isErrorPage="true" language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Online store error page</title>
</head>
<body>

	<h2 style="color:red">Ups! There was an error in your super online store!</h2>

	<div id="errorContent">
		<p>
			Error details:
		</p>
		<ul>
			<li>Error date: <%= new Date() %></li>
			<li>Error type: <%= exception.toString()  %>
		</ul>
	</div>
	
	<form action="<%=request.getServletContext().getContextPath()%>/login.jsp">
		<input type="submit" value="Back to home" />
	</form>
	
</body>
</html>