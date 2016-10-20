<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/city/update">
    <input type="hidden" name="id" value="${city.id}">
    <table>
        <tr>
            <td>City name:</td>
            <td><input type="text" name="city_name" value="${city.name}"/></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><select name="country">
                <c:forEach items="${countries}" var="country">
                    <option value="${country.id}" <c:if
                        test="${country.id == city.countryDto.id}">selected </c:if>>${country.name}</option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td>Population:</td>
            <td><input type="text" name="population" value="${city.population}"/></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>