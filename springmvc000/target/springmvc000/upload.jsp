<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/15
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
单文件提交：
<form action="${ctx}/file/upload" method="post" enctype="multipart/form-data">
    文件：<input type="file" name="file"/><br>
    <input type="submit" value="提交">
</form>
<br>
多文件提交：
<form action="${ctx}/file/upload2" method="post" enctype="multipart/form-data">
    文件1：<input type="file" name="file"/><br>
    文件2：<input type="file" name="file"/><br>
    文件3：<input type="file" name="file"/><br>
    文件4：<input type="file" name="file"/><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
