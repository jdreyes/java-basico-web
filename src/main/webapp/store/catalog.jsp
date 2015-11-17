<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.autentia.training.javabasico.core.bean.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online store catalog</title>

<link rel="stylesheet" type="text/css" href="../css/catalog.css">
</head>

<jsp:useBean id="videogame" class="com.autentia.training.javabasico.core.bean.Product" scope="session">
	<jsp:setProperty name="videogame" property="name" value="Videogame" />
	<jsp:setProperty name="videogame" property="description" value="Bug!-the videogame for Autentia Box 360 (30% off!)" />
	<jsp:setProperty name="videogame" property="price" value="35.90" />
</jsp:useBean>

<jsp:useBean id="autentiabox360" class="com.autentia.training.javabasico.core.bean.Product" scope="session">
	<jsp:setProperty name="autentiabox360" property="name" value="Autentia Box 360" />
	<jsp:setProperty name="autentiabox360" property="description" value="Best console in the world" />
	<jsp:setProperty name="autentiabox360" property="price" value="330" />
</jsp:useBean>

<body>

	<p>Welcome <%= session.getAttribute("user") %></p>
	
	<p>Your session ID is: <%= session.getId() %></p>
	
	<div>
		<h2>Items in stock:</h2>
		
		<div class="stockItem">
			<h3><jsp:getProperty name="videogame" property="name"/></h3>
			<hr/>
			<p><jsp:getProperty name="videogame" property="description"/> 
				<span>
					<strong>
						<jsp:getProperty name="videogame" property="price"/> euro
					</strong>
				</span> 
			</p>
		</div>
		
		<div class="stockItem">
			<h3><jsp:getProperty name="autentiabox360" property="name"/></h3>
			<hr/>
			<p><jsp:getProperty name="autentiabox360" property="description"/> 
				<span>
					<strong>
						<jsp:getProperty name="autentiabox360" property="price"/> euro
					</strong>
				</span> 
			</p>
		</div>
		
	</div>
	
	<%-- Current JSP variables 
	<div id="variables">
		<h3>JSP Variables:</h3>
		<p><strong>Request:</strong> <%= request %></p>
		<p><strong>Response:</strong> <%= response %></p>
		<p><strong>Out:</strong> <%= out %></p>
		<p><strong>Session:</strong> <%= session %></p>
		<p><strong>Application:</strong> <%= application %></p>
		<p><strong>Config:</strong> <%= config %></p>
		<p><strong>PageContext:</strong> <%= pageContext %></p>
		<p><strong>Page:</strong> <%= page %></p>
	</div>
	--%>
	<form action="../logout" method="post">
		<input type="submit" value="Logout"/>
	</form>
	
</body>
</html>