<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update profile</title>
</head>
<body>

<form:form action="updateProfile" method="post">
    <input type="text" name="name" value="${customer.name}">
    <input type="text" name="email" value="${customer.email}">
    <input type="text" name="phone" value="${customer.telephone}">
    <input type="text" name="password">
    <button>save updates</button>
</form:form>


</body>
</html>