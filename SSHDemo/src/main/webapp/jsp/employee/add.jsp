<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<table style="width:550px">
		<tr>
			<td align="center" style="font-size:24px; color:#666">员工添加</td>
		</tr>
		<tr>
			<td align="center">
				<a href="javascript:document.getElementById('saveForm').submit()">保存</a> 
					&nbsp;&nbsp; 
				<a href="javascript:history.go(-1)">退回</a>
			</td>
		</tr>
	</table>
	<br />
	<s:form id="saveForm" action="employee_save" method="post" namespace="/" theme="simple">
		<table style="font-size:16px">
			<tr>
				<td>姓名：</td>
					<td><s:textfield name="ename" />
				</td>
				<td>性别：</td>
				<td><s:radio name="sex" list="{'男','女'}" /></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><s:textfield name="username" /></td>
				<td>密码：</td>
				<td><s:password name="password" /></td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td><s:textfield name="birthday" /></td>
				<td>入职时间：</td>
				<td><s:textfield name="joinDate" /></td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="----请选择----"/></td>
				<td>编号：</td>
				<td><s:textfield name="eno" /></td>
			</tr>
		</table>
	</s:form>
</body>
</html>