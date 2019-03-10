<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:if test="${empty code}">
    <h2>修改密码</h2>
    <form action="${ctx}/account/changePwd" method="post">
        <b>旧密码</b><input type="text" name="pwd"><br>
        <b>新密码：</b><input type="text" name="pwd1"><br>
        <b>确认新密码：</b><input type="text" name="pwd2"><br>
        <input type="submit" value="确认修改">
    </form>
</c:if>
<c:if test="${not empty code}">
    <c:if test="${code == 2000}">
        <h4>修改成功！</h4>
    </c:if>
    <c:if test="${code == 2100}">
        <script>
            alert('修改失败');
        </script>
    </c:if>
</c:if>
<script>
    console.log('${code}')
</script>
