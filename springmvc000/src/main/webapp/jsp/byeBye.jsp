<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/13
  Time: 19:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table border="1">
        <c:forEach items="${model}" var="obj">
            <tr>
                <td>${obj.name}</td>
                <td>${obj.sex}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>
