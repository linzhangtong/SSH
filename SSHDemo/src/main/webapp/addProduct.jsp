<%--
  Created by IntelliJ IDEA.
  User: Elric
  Date: 2017/5/6
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
<h1>保存商品的信息</h1>
<s:form action="product_save" method="post" namespace="/" theme="simple">
    <table border="1" width="400">
        <tr>
            <td>商品名称</td>
            <td><s:textfield name="pName"/></td>
        </tr>
        <tr>
            <td>商品价格</td>
            <td><s:textfield name="pPrice"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="添加"></td>
        </tr>
    </table>
</s:form>
</body>
</html>
