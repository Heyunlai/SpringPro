<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/19
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <c:if test="${not empty code and not empty msg}">
        <c:if test="${code == true}">
            <h4>${msg}</h4>
        </c:if>
        <c:if test="${code != true}">
            <script>
                alert('${msg}');
            </script>
        </c:if>
    </c:if>

    <c:if test="${empty code and empty msg}">
        <h2>当前操作是转账</h2>
        <form action="${ctx}/account/transfer" method="post">
            <b>转入账号：</b><input type="text" name="cardNo"><br>
            <b>转入金额：</b><input type="text" name="transactionAmount"><br>
            <input type="submit" value="转账">
        </form>
    </c:if>
</div>

