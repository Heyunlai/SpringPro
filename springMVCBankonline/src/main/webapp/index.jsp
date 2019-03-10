<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${ctx}/static/css/index.css">
    <meta charset="UTF-8"/>
    <script src="${ctx}/static/js/jquery.js"></script>
    <title>Title</title>
</head>
<body>

   <div id="main">
      <form action="${ctx}/account/login" method="post" onsubmit="return check()">
          <h1>个人网上银行</h1>
          <b>卡号：</b><input type="text" name="cardNo">
          <br>
          <b>密码：</b><input type="password" name="password">
          <br>
          <input type="submit" value="登录网上银行">
      </form>
   </div>
<script>
    var errorMsg='${errorMsg}';
    if(errorMsg!==null && errorMsg !=undefined && errorMsg!=""){
         alert(errorMsg);
    }
    function check() {
        console.log($('input[name=cardNo]').val());
        var cardNo=$('input[name=cardNo]').val();
        if(cardNo.length != 16){
            alert("卡号长度必须为16位");
            return false;
        }

        var pwd =$('input[name=passward]').value();
        if (pwd.length != 6){
            alert("密码必须为6位");
            return false;
        }
        return true;
    }
</script>

</body>
</html>
