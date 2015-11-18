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
	
	<div id="userInfoContent">
		<p>Welcome <%= session.getAttribute("user") %></p>
		<p>Your session ID is: <%= session.getId() %></p>
	
		<form action="../logout" method="post">
			<input type="submit" value="Logout"/>
		</form>
		
	</div>
	
	<hr/>
	
	<div id="shoppingCartContent">
		<h3>Your shopping cart:</h3>
		
		<p>Number of items: <%=session.getAttribute("shoppingCartNItems")%> items</p>
		<p>Total amount: <%=session.getAttribute("shoppingCartTotalAmount")%> euro</p>
	</div>
	
	<hr/>
	
	<div id="stockContent">
		<h2>Items in stock:</h2>
		
		<div class="stockItem">
			<h3><jsp:getProperty name="videogame" property="name"/></h3>
			<hr/>
			<p><jsp:getProperty name="videogame" property="description"/> 
			</p>
			<p><strong><jsp:getProperty name="videogame" property="price"/> euro</strong></p>
		</div>

		<div class="stockItem">
			<h3><jsp:getProperty name="autentiabox360" property="name"/></h3>
			<hr/>
			<p><jsp:getProperty name="autentiabox360" property="description"/></p>
			<p><strong><jsp:getProperty name="autentiabox360" property="price"/> euro</strong></p>
		</div>
		
	</div>
	
	<br/>
	
</body>
</html>