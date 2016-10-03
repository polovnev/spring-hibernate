<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/country/update">
    <input type="hidden" name="id" value="${country.id}">
    <table>

        <tr>
            <td>Country name:</td>
            <td><input type="text" name="country_name" value="${country.name}"/></td>
        </tr>
        <tr>
            <td>Population:</td>
            <td><input type="text" name="population" value="${country.population}"/></td>
        <tr>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>