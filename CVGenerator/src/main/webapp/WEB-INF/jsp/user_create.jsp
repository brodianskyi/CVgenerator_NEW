<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<img src="/resources/images/codecentric-ag.gif" style="float: all; padding: 0 5px 5px 30px;" />
<form:form method="POST" action="/user_create" modelAttribute="user">
<h1>Registrieren</h1>
    <form:errors path="" element="td"/>
    
    <table>
    <tr>
       <td width="25%"> Name</td>
       <td width="25%"><form:input path="name"/></td>
       <td width="25%"><form:errors path="name" cssClass="error"/></td>
    </tr>
    <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
     <tr>
       <td width="25%"> Vorname</td>
       <td width="25%"><form:input path="vorname"/></td>
       <td width="25%"><form:errors path="vorname" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
     <tr>
       <td width="25%"> Geburtsdatum</td>
       <td width="25%"><form:input type="date" path="geburtsdatum" value="${vacancy.date}" pattern="DD-MM-YYYY"/></td>
       <td width="25%"><form:errors path="geburtsdatum" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
     <tr>
       <td width="25%"> Wohnort</td>
       <td width="25%"> <form:input path="wohnort"/></td>
       <td width="25%"><form:errors path="wohnort" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
     <tr>
       <td width="25%"> Nationalität</td>
       <td width="25%"> <form:input path="nationalitaet"/></td>
       <td width="25%"><form:errors path="nationalitaet" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
     <tr>
       <td width="25%"> Sprachen</td>
       <td width="25%"> <form:input path="sprachen"/></td>
       <td width="25%"><form:errors path="sprachen" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
     <tr>
       <td width="25%"> Telefon</td>
       <td width="25%"> <form:input path="telefon"/></td>
       <td width="25%"><form:errors path="telefon" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
    <tr>
       <td width="25%"> Email</td>
       <td width="25%"> <form:input path="email"/></td>
       <td width="25%"><form:errors path="email" cssClass="error"/></td>
    </tr>
      <tr>
       <td width="25%"></td>
	   <td width="25%"></td>
	   <td width="25%"></td>
	</tr>
    <tr>
	   <td width="25%"><input type="submit" value="Login" /></td>
    </tr>
    </table>
</form:form>
</body>
</html>
