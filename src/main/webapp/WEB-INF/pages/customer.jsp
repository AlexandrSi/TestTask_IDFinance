<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>

</head>

<body>
<form method="get">
    <p><textarea name="json" cols="48" rows="8"> </textarea></p>
    <p><input type="submit" formaction="/sendStmt"></p>
    <p><input type="submit" formaction="/checkStatus" value="Статус"></p>
</form>
<c:out value="${customer}"></c:out>
<c:out value="${id}"></c:out>
</body>
</html>