<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/15
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${ctx}/user/login" method="post">
    名：<input type="text" name="name"><br>
    密：<input type="password" name="pwd"><br>
    <input  type="submit" value="登录">
</form>
</body>
</html>
