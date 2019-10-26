<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Регистрация</title>
</head>
<body>
<a href="http://localhost:8080/webapp/mainProc">Главная</a>
<a href="">Плагины</a>
<div>${message}</div>
<form:form method="POST" modelAttribute="userReg" action="registration">
   Логин <form:input type="text" path="login"/><br/>
   Пароль <form:input type="password" path="password"/><br/>
    <button>register</button>
</form:form>
</body>
</html>