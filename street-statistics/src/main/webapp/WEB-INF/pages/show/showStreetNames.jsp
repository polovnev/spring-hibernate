<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<my:menu/>
<c:forEach items="${streetNames}" var="streetName">
    <a href="/show/streetNameDetail?idStreetName=${streetName.id}"><h1>${streetName.name}</h1></a>
    <hr/>
    <a href="/remove/streetName?id=${streetName.id}">remove</a> <a href="/update/streetName?id=${streetName.id}">change</a>
    <hr/>
</c:forEach>
</body>
</html>