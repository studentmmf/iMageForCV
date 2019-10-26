<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 2019-08-28
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Авторизация</title>
</head>
<body>
<a href="http://localhost:8080/webapp/mainProc">Главная</a>
<a href="">Плагины</a>
<a href="showReg">Зарегистрироваться</a>
<div>${message}</div>


<form method="POST" action="login">
   Логин <input required type="text" name="login"/><br/>
   Пароль <input required type="password" name="password"/><br/>
    <input type="submit" value="login"/>
</form>
<a href="">Забыли пароль?</a>
</body>
</html>

