<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<style type="text/css">
a {
	text-decoration: none;
}
.table1 {
	border: 1px solid #ddd;
	width: 900px;
}
th{
	border:1px solid #ddd;
} 
.myTd{
	border:1px solid #efe;
} 
thead {
	background-color: lightblue;
}
</style>
</head>
<body>
	<table style="width:900px;">
		<tr>
			<td align="center" style="font-size:24px; color:#666">员工管理</td>
		</tr>
		<tr>
			<td align="center">
				<a href="employee_saveUI.action">添加</a>
			</td>
		</tr>
	</table>
	<br />
	<table style="width:900px;">
		<thead>
			<tr>
				<th align="center">编号</th>
				<th align="center">员工姓名</th>
				<th align="center">性别</th>
				<th align="center">出生日期</th>
				<th align="center">入职时间</th>
				<th align="center">所属部门</th>
				<th align="center">编辑</th>
				<th align="center">删除</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="list" var="e">
			<tr>
				<td class="myTd" align="center"><s:property value="#e.eno"/></td>
				<td class="myTd" align="center"><s:property value="#e.ename"/></td>
				<td class="myTd" align="center"><s:property value="#e.sex"/></td>
				<td class="myTd" align="center"><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
				<td class="myTd" align="center"><s:date name="#e.joinDate" format="yyyy-MM-dd"/></td>
				<td class="myTd" align="center"><s:property value="#e.department.dname"/></td>
				<td class="myTd" align="center"><a href="employee_edit.action?eid=<s:property value="#e.eid"/>"><img src="images/edit.png"></a></td>
				<td class="myTd" align="center"><a href="employee_delete.action?eid=<s:property value="#e.eid"/>"><img src="images/trash.gif"></a></td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	<br />
	<table style="width:900px;">
		<tr>
			<td align="right">
				<span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
				<span>总记录数：<s:property value="totalCount"/>每页显示：<s:property value="pageSize"/></span>&nbsp;&nbsp;
				<span> 
					 <s:if test="currPage!=1">
					 	<a href="employee_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
						<a href="employee_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp; 
					 </s:if>
					<s:if test="currPage!=totalPage">
						<a href="employee_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
						<a href="employee_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
					</s:if>
				</span>
			</td>
		</tr>
	</table>
</body>
</html>