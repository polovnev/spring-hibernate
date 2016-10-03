<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<my:menu/>
<c:forEach items="${streets}" var="street">
    <h1>${street.length}</h1>
    <hr/>
    <a href="/street/remove?id=${street.id}">remove</a> <a href="/street/update?id=${street.id}">change</a>
    <hr/>
</c:forEach>
</body>
</html>