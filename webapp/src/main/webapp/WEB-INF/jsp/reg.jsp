<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Регистрация</title>
</head>
<body>
<a href="">Главная</a>
<a href="">Плагины</a>
<div>${message}</div>
<form method="get" modelAttribute="userJSP" action="registration">
   Логин <input type="text" path="login"/><br/>
   Пароль <input type="text" path="password"/><br/>
    <button>register</button>
</form>
</body>
</html>