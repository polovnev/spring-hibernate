<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title>Countries</title>
</head>
<body>
<my:menu/>
<c:forEach items="${streetNames}" var="streetNameInfo">
    <h1>${streetNameInfo.name}</h1>
    <hr/>
    <a href="/streetNameInfo/remove?id=${streetNameInfo.id}">remove</a> <a href="/streetNameInfo/update?id=${streetNameInfo.id}">change</a>
    <hr/>
</c:forEach>
</body>
</html>