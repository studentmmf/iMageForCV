<%--
  Created by IntelliJ IDEA.
  User: dmitry
  Date: 2019-08-28
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
<a href="">Главная</a>
<a href="">Плагины</a>
<a href="reg.jsp">Зарегистрироваться</a>
<div>${message}</div>
<div>${debug}</div>

<form:form method="get" modelAttribute="userJSP" action="login">
   Логин <form:input type="text" path="login"/><br/>
   Пароль <form:input type="text" path="password"/><br/>
    <input type="submit" value="login"/>
</form:form>
<a href="">Забыли пароль?</a>
</body>
</html>--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST"
          action="/spring-mvc-xml/addEmployee" modelAttribute="employee">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="contactNumber">
                      Contact Number</form:label></td>
                    <td><form:input path="contactNumber"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>