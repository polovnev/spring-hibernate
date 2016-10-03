<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/city/add">

    <table>
        <tr>
            <td>City name:</td>
            <td><input type="text" name="city_name"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><select name="country">
                <c:forEach items="${countries}" var="country">
                    <option value="${country.id}">${country.name}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Population:</td>
            <td><input type="text" name="population"/></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>