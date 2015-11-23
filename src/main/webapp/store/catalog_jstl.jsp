<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.autentia.training.javabasico.core.bean.Product"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online store catalog</title>

<link rel="stylesheet" type="text/css" href="../css/catalog.css">
</head>

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
		<p>Total amount: <%=session.getAttribute("shoppingCartTotalAmount")%>€</p>
	
		<input type="button" value="Checkout!" disabled/>
	</div>
	
	<hr/>
	
	<div id="stockContent">
		<h2>Items in stock:</h2>
		
		<c:forEach items="${productList}" var="product">
		
			<div class="stockItem">
				<h3>${product.name}</h3>
				<hr/>
				<p>${product.description}
				</p>
				<p><strong>${product.price}</strong></p>
				
				<form action="shoppingCart/addToCart?price=${product.price}" method="post">
					<input type="submit" value="Add to cart"/>
				</form>
			</div>

		</c:forEach>
		
	</div>
	
	<br/>
	
</body>
</html>