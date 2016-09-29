<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<my:menu/>
<form method="post" action="/add/streetName">
    <table>
        <tr>
            <td>Street name:</td>
            <td><input type="text" name="street_name"/></td>
        </tr>
        <tr>
            <td>is Person:</td>
            <td><input type="checkbox" name="person" value="person"/></td>
        <tr>
        <tr>
            <td>Description:</td>
            <td><textarea rows="10" cols="45" name="description"></textarea></td>
        <tr>
            <td><input type="submit"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>