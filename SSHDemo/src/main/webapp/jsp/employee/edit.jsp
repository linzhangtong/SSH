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
	<s:form id="saveForm" action="employee_update" method="post" namespace="/" theme="simple">
		<s:hidden name="eid" value="%{model.eid}"/>
		<table style="font-size:16px">
			<tr>
				<td>姓名：</td>
				<td><s:textfield name="ename" value="%{model.ename}"/></td>
				<td>性别：</td>
				<td><s:radio name="sex" list="{'男','女'}" value="%{model.sex}"/></td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><s:textfield name="username" value="%{model.username}"/></td>
				<td>密码：</td>
				<td><s:password name="password" value="%{model.password}" showPassword="true"/></td>
			</tr>
			<tr>
				<td>出生日期：</td>
				<td>
					<input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>">
				</td>
				<td>入职时间：</td>
				<td>
					<input type="text" name="joinDate" value="<s:date name="model.joinDate" format="yyyy-MM-dd" />">
				</td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td>
					<s:select name="department.did" list="list" value="%{model.department.did}" listKey="did" listValue="dname" headerKey="" headerValue="----请选择----"/>
				</td>
				<td>编号：</td>
				<td><s:textfield name="eno" value="%{model.eno}"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>