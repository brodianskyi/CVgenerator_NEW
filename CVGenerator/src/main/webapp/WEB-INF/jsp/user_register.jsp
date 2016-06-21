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
		<form:form method="POST" action="home"  modelAttribute="user">
			    <tr>
					<td>Name: </td>
					<td><form:input path="name" size="30"/></td>
					<td ><form:errors path="name" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Geburtsdatum: </td>
					<td><form:input type="date" path="geburtsdatum" value="${vacancy.date}" pattern="yyyy-MM-dd"/></td>
					<td ><form:errors path="geburtsdatum" cssClass="error"/></td>
				</tr>
				
				<tr>
					<td>Wohnort: </td>
					<td><form:input path="wohnort" size="30"/></td>
					<td><form:errors path="wohnort" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Nationalität: </td>
					<td><form:input  path="nationalitaet" size="30"/></td>
					<td><form:errors path="nationalitaet" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Sprachen: </td>
					<td><form:input path="sprachen" size="30"/></td>
					<td><form:errors path="sprachen" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Telefon: </td>
					<td><form:input  path="telefon" size="30"/></td>
					<td><form:errors path="telefon" cssClass="error"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input path="email" size="30"/></td>
					<td><form:errors path="email" cssClass="error"/></td>
				</tr>
				
				<tr>
					<tr>
					<td></td>
					<td align="center"><input type="submit" value="Register"/></td>
					<td></td>
				</tr>
		</form:form>
		</table>
	</div>
</body>
</html>