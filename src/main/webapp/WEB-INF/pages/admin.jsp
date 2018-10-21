<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>

<body>
<div align="center">
    <form method="get">
    <table border="1" cellpadding="5">
        <caption><h2>List of users</h2></caption>
        <tr>
            <th>id</th>
            <th>request</th>
            <th>bid</th>
            <th>due_date</th>
            <th>status</th>
            <th>accept</th>
            <th>reject</th>
        </tr>
        <c:forEach items="${adminList}" var="user" >
            <tr>
                <td><c:out value="${user.id}" /></td>
                <td><c:out value="${user.request}" /></td>
                <td><c:out value="${user.bid}" /></td>
                <td><c:out value="${user.dueDate}" /></td>
                <td><c:out value="${user.status}" /></td>
                <td><input type="button" onclick="location.href='/change?id=<c:out value="${user.id}"/>&decision=Accepted';" value="Accepted" /></td>
                <td><input type="button" onclick="location.href='/change?id=<c:out value="${user.id}"/>&decision=Reject';" value="Reject" /></td>
            </tr>
        </c:forEach>
    </table>
    </form>
    Выполнено
    <c:out value="${done}"/>
    Отказано
    <c:out value="${denied}"/>
</div>
</body>
</html>