<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: he
  Date: 2019/2/21
  Time: 16:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <form action="${ctx}/transferRecord/query" method="post">
        <h2>查询交易记录</h2>
        <input type="hidden" name="cardNo" value="${SESSION_ACCOUNT.cardNo}">
        <input type="hidden" name="pageNum" value="1">
        <input type="hidden" name="pageSize" value="3">
        <b>起始时间：</b><input type="date" name="start"  ><br>
        <b>截止时间：</b><input type="date" name="end"  ><br>
        <input type="submit" value="查询">
        <table border="1">
            <thead>
            <tr>
                <th>交易日期</th>
                <th>交易金额</th>
                <th>账号余额</th>
                <th>交易类型</th>
                <th>备注</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${records.list}" var="obj">
                <tr>
                    <td>${obj.transactionDate}</td>
                    <td>${obj.transactionAmount}</td>
                    <td>${obj.balance}</td>
                    <td>${obj.transactionType}</td>
                    <td>${obj.remark}</td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5">
                    <a data-for="page-first" href="javascript:void(0);">首页</a>|
                    <a data-for="page-prev" href="javascript:void(0);">上一页</a>|
                    <a data-for="page-next" href="javascript:void(0);">下一页</a>|
                    <a data-for="page-last" href="javascript:void(0);">尾页</a>|
                    第${records.pageNum}页/共${records.pages}页（${records.total}条记录）
                </td>
            </tr>
            </tbody>

        </table>
    </form>

<script src="${ctx}/static/js/jquery.js"></script>

<script>
    $(function () {

        var start=$('input[name=start]').val();
        var end=$('input[name=end]').val();
        $('a[data-for^=page]').click(function () {
            var val =$(this).attr('data-for');
            var pageNum ='${records.pageNum}';
            switch (val){
                case 'page-first':
                    pageNum=1;
                    break;
                case 'page-prev':
                    pageNum=pageNum-1;
                    break;
                case 'page-next':
                    pageNum=parseInt(pageNum)+1;
                    break;
                case 'page-last':
                    pageNum ='${records.pages}';
                    break;
            }
            $('input[name=pageNum]').val(pageNum);
            $('input[name=start]').val(start);
            $('input[name=end]').val(end);
            $('form').submit();
        });
    })
</script>


