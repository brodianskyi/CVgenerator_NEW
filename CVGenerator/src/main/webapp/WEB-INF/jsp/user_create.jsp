<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form method="POST" action="/user_create.html" modelAttribute="helper">
    <form:errors path="" element="div"/>
    <div>
        <form:label path="id"><spring:message code="helper.id"/></form:label>
        <form:input path="id"/>
        <form:errors path="id"/>
    </div>
    <div>
        <form:label path="password1"><spring:message code="helper.password1"/></form:label>
        <form:password path="password1"/>
        <form:errors path="password1"/>
    </div>
    <div>
        <form:label path="password1"><spring:message code="helper.password2"/></form:label>
        <form:password path="password2"/>
        <form:errors path="password2"/>
    </div>
    <div>
        <input type="submit"/>
    </div>
</form:form>
</body>
</html>
