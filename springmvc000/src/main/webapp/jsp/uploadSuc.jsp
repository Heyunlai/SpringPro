<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/15
  Time: 10:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${fileName}
<c:forEach items="${fileNames}" var="fileName">
    ${fileName}<br>
</c:forEach>
</body>
</html>
