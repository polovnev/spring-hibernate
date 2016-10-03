<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/street/update/">
    <input type="hidden" name="id" value="${street.id}">
    <table>
        <tr>
            <td>City:</td>
            <td><select name="city">
                <c:forEach items="${cities}" var="city">
                    <option value="${city.id}" <c:if
                            test="${city.id == street.cityId}">selected </c:if>>${city.name}</option>
                </c:forEach>
            </select></td>
        </tr>

        <tr>
            <td>Street name:</td>
            <td><select name="streetName">
                <c:forEach items="${streetNames}" var="streetName">
                    <option value="${streetName.id}" <c:if
                            test="${streetName.id == street.streetNameId}">selected </c:if>>${streetName.name}</option>
                </c:forEach>
            </select></td>
        </tr>

        <tr>
            <td>Length:</td>
            <td><input type="text" name="length" value="${street.length}"/></td>
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