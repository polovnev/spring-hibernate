<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<my:header></my:header>
<c:forEach items="${countries}" var="country">
    <a href="/city/show?idCountry=${country.id}"><h1>${country.name}</h1></a>
    <input type="radio" name="country" value="${country.id}">
    <hr/>
    <a href="/country/remove?id=${country.id}">remove</a> <a href="/country/update?id=${country.id}">change</a>
    <hr/>
</c:forEach>
</body>
</html>