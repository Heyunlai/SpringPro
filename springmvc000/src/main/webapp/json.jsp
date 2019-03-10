<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/14
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${ctx}/static/js/jquery.js"></script>
</head>
<body>
   <button id="b">请求一个人</button>
   <button id="bb">发送一个人</button>

   <script>
       $(function () {
//           从后台请求一个人
           $("#b").click(function () {
               $.ajax({
                   url:'${ctx}/json/m1',
                   type:'post',
                   success:function (data) {
                       alert(data.name+":"+data.sex)
                   }
               })
           });
           
           
//           向后台发送一个人
           $("#bb").click(function () {
               var obj={
                   'name':'Li 李',
                   'sex':'girl'
               };

               $.ajax({
                   url:'${ctx}/json/m2',
                   type:'post',
                   contentType:'application/json',
                   data:JSON.stringify(obj),
                   success:function (data) {
                       alert(data.name);
                   }
               })
           })
       })

   </script>
</body>
</html>
