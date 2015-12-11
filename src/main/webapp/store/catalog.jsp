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
	
	<h1>Welcome to <%= request.getAttribute("applicationName")%> store (v<%=request.getAttribute("applicationVersion")%>)</h1>
	
	<div id="userInfoContent">
		<p>Welcome <%= session.getAttribute("user") %>. 
		Your session ID is: <%= session.getId() %>	
		</p>
		
		<form action="../logout" method="post">
				<input type="submit" value="Logout"/>
		</form>
			
	</div>
	
	
	<div id="shoppingCartContent">
		<h3>Your shopping cart:</h3>
		
		<p>Number of items: <%=session.getAttribute("shoppingCartNItems")%> items</p>
		<p>Total amount: <%=session.getAttribute("shoppingCartTotalAmount")%>€</p>
	
		<input type="button" value="Checkout!" disabled/>
	</div>
	
	
	<div id="stockContent">
		<h2>Items in stock:</h2>
		
		<table>
			
            
		<% for (Product product : productList) { %>
		<tr class="stockItem">
			<th><%=product.getName()%></th>
            
            <tr><td><%=product.getDescription()%></td></tr>
            <tr><td><strong><%=product.getPrice().floatValue()%></strong></td></tr>
            <tr>
            	<td>
            		<form action="shoppingCart/addToCart?name=<%=product.getName()%>&price=<%=product.getPrice().floatValue()%>" method="post">
						<input type="submit" value="Add to cart"/>
					</form>
				</td>
            </tr>
		</tr>

		<%}%>
		
	</div>
	
	<br/>
	
</body>
</html>