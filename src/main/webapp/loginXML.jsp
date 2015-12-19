<?xml version="1.0" encoding="UTF-8"?>
<%@ page language="java" contentType="text/xml"%>

<%-- Declare variables --%>
<%! String jspString = "JSP is cool!"; %>
<root>
	<entity>Hello, world from XML</entity>
	
	<% if(jspString != null) { %>
		<coolJsp><%= jspString %></coolJsp>
	<% } %>
	
</root>