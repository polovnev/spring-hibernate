<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<my:menu/>
<c:forEach items="${countries}" var="country">
    <a href="/show/cities?idCountry=${country.id}"><h1>${country.name}</h1></a>
    <hr/>
    <a href="/remove/country?id=${country.id}">remove</a> <a href="/update/country?id=${country.id}">change</a>
    <hr/>
</c:forEach>
</body>
</html>