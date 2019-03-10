<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/19
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        *{
            margin: 0;
        }
        #main{
            width: 80%;
            margin: 10px auto;
            background-color: antiquewhite;
            border: 1px solid black;
        }
        #main-head{
            margin-top: 10px;
        }
        .float{
            float: left;
        }
        .left{
            margin:50px 50px;
        }
        .right{
            border: 1px solid black;
            margin-left:50px;
            margin-top: 50px;
            height: 400px;
            width: 600px;
        }
        .clearfloat::after{
           content: "";
            height: 0;
            display: block;
            visibility: hidden;
            clear: both;
        }
    </style>
</head>
<body>
<div id="main">
    <div id="main-head">
        <b>卡号</b>${SESSION_ACCOUNT.cardNo}<a href="${ctx}/account/logout">退出登录</a>
    </div>
    <div class="clearfloat">
        <div class="left float">
            <div><a href="${ctx}/account/balance/${SESSION_ACCOUNT.cardNo}">查询余额</a></div>
            <div><a href="${ctx}/account/transferTo">转账</a></div>
            <div><a href="${ctx}/transferRecord/index">查询交易</a></div>
            <div><a href="${ctx}/account/changeTo">修改密码</a></div>
        </div>
        <div class="right float">
            <c:if test="${page eq 'balance'}">
                <jsp:include page="balance.jsp"/>
            </c:if>
            <c:if test="${page eq 'transfer'}">
            <jsp:include page="transfer.jsp"/>
            </c:if>
            <c:if test="${page eq 'transferRecord'}">
                <jsp:include page="record.jsp"/>
            </c:if>
            <c:if test="${page eq 'changePwd'}">
                <jsp:include page="changePwd.jsp"/>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
