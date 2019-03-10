<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/13
  Time: 21:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
</head>
<body>
<%--请求路径永远写 /
    / 代表上下文容器，servlet容器，Tomcat
    /项目名/url--%>
get
<form action="${ctx}/he/m1" method="get">
    <input type="submit" value="提交"/>
</form>
<br>
post
<form action="${ctx}/he/m1" method="post">
    <input type="submit" value="提交"/>
</form>
<br>
delete
<form action="${ctx}/he/m1" method="post">
    <input type="hidden" name="_method" value="DELETE"/>
    <input type="submit" value="提交"/>
</form>
<br>
put people
<form action="${ctx}/people/put" method="post">
    <input type="hidden" name="_method" value="put"/>
    <input type="text" name="name"/><br>
    <input type="password" name="sex"/><br>
    <input type="submit" value="提交"/>
</form>

put people and date
<form action="${ctx}/people/date" method="post">
    <input type="date" name="date"/><br>
    <input type="submit" value="提交"/>
</form>
<br>

post people to other page
<form action="${ctx}/people2/login3" method="post">
    <input type="text" name="name"/><br>
    <input type="password" name="sex"/><br>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
