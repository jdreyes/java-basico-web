<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.autentia.training.javabasico.core.bean.Product"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Online store catalog</title>

<link rel="stylesheet" type="text/css" href="../css/catalog.css">
</head>

<%
	List<Product> productList = (List<Product>)request.getAttribute("productList");
%>

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
		
		<% for (Product product : productList) { %>
		<div class="stockItem">
			<h3><%=product.getName()%></h3>
			<hr/>
			<p><%=product.getDescription()%> 
			</p>
			<p><strong><%=product.getPrice().floatValue()%></strong></p>
			
			<form action="shoppingCart/addToCart?name=<%=product.getName()%>&price=<%=product.getPrice().floatValue()%>" method="post">
				<input type="submit" value="Add to cart"/>
			</form>
		</div>

		<%}%>
		
	</div>
	
	<br/>
	
</body>
</html>