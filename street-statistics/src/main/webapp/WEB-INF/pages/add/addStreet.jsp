<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/street/add">
    <table>
        <tr>
            <td>City:</td>
            <td><select name="city">
                <c:forEach items="${cities}" var="city">
                    <option value="${city.id}">${city.name}</option>
                </c:forEach>
            </select></td>
        </tr>

        <tr>
            <td>Street name:</td>
            <td><select name="streetNameInfo">
                <c:forEach items="${streetNames}" var="streetNameInfo">
                    <option value="${streetNameInfo.id}">${streetNameInfo.name}</option>
                </c:forEach>
            </select></td>
        </tr>

        <tr>
            <td>Length:</td>
            <td><input type="text" name="length"/></td>
        </tr>

        <tr>
        <tr>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>