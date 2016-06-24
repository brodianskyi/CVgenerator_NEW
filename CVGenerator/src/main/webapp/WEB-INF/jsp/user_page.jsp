<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="com.codecentric.cvgenerator.api.entities.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserPage</title>
<style>
	.error { 
		color: red; font-weight: bold; 
	}
</style>
</head>
<body>
 <img src="/resources/images/codecentric-ag.gif" style="float: all; padding: 0 5px 5px 30px;" />
 <jsp:useBean id="user" scope="session" class="com.codecentric.cvgenerator.api.entities.User"/>
 <%
    if (session.getAttribute("user") == null ){// Then new user, show join now
 %>
    <div>Email:</div>
 <%
    }else { 
 %>
    <div>Email123:</div>
  <%
    }
  %>
  
	<div align="center">
		<h2>Ihre Datei</h2>
		<% 
         user = (User) session.getAttribute("user");
	    %>
		<table border="0" width="90%">
		
			    <tr>
					<td>Email:</td>
					<td> <%= user.getEmail() %> </td>
					<td></td>
				</tr>
				
				
				<tr>
					
					<td></td>
					<td><input type="submit" value="Login"/></td>
					<td></td>
				
				</tr>
				
		
		
		</table>
	</div>
	<div>
	
		   <table border="0" width="90%">
		          <tr>
					
					<td></td>
					<td><input type="submit" value="Registration"/></td>
					<td></td>
				
				</tr>
		   </table>      
		
	</div>
	
</body>
</html>