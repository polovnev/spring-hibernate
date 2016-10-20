<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/streetNameInfo/update">
    <input type="hidden" name="id" value="${streetNameInfo.id}"/>
    <table>
        <tr>
            <td>Street name:</td>
            <td><input type="text" name="street_name" value="${streetNameInfo.name}"/></td>
        </tr>
        <tr>
            <td>is Person:</td>
            <td><input type="checkbox" name="person" value="person" <c:if
                    test="${streetNameInfo.person}">checked/></c:if></td>
        </tr>
        <tr>
            <td>Description:</td>
            <td><textarea rows="10" cols="45" name="description">${streetNameInfo.description}</textarea></td>
        </tr>
        <tr>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>