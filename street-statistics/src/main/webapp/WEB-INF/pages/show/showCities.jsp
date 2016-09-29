<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<my:menu/>
<c:forEach items="${cities}" var="city">
    <a href="/show/streets?idCity=${city.id}"><h1>${city.name}</h1></a>
    <hr/>
    <a href="/remove/city?id=${city.id}">remove</a> <a href="/update/city?id=${city.id}">change</a>
    <hr/>
</c:forEach>
</body>
</html>