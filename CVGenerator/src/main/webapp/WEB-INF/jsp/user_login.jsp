<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<style>
	.error { 
		color: red; font-weight: bold; 
	}
</style>
</head>
<body>
	<div align="center">
		<h2>User Registration</h2>
		<table border="0" width="90%">
		<form:form method="POST" action="user_login"  modelAttribute="user_login_form">
			    <tr>
					<td>Email: </td>
					<td><form:input path="email" size="30"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Password: </td>
					<td><form:input path="password" size="30"/></td>
					<td><form:errors path="password" cssClass="error"/></td>
				</tr>
				
				<tr>
					
					<td></td>
					<td><input type="submit" value="Login"/></td>
					<td></td>
				
				</tr>
				
		</form:form>
		
		</table>
	</div>
	<div>
	<form:form method="GET" action="user_create">  
		   <table border="0" width="90%">
		          <tr>
					
					<td></td>
					<td><input type="submit" value="Registration"/></td>
					<td></td>
				
				</tr>
		   </table>      
		</form:form>
	</div>
	
</body>
</html>