<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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
	<table style="width:800px;">
		<tr>
			<td align="center" style="font-size:24px; color:#999">部门管理</td>
		</tr>
		<tr>
			<td align="center"><a href="department_saveUI.action">添加</a></td>
		</tr>
	</table>
	<br />
	<table class="table1">
		<thead>
			<tr>
				<th width="450">部门名称</th>
				<th width="450">描述</th>
				<th width="450">编辑</th>
				<th width="450">删除</th>
			</tr>
		</thead>
		<tbody>
		<s:iterator value="list" var="d">
			<tr>
				<td class="myTd" align="center"><s:property value="#d.dname"/></td>
				<td class="myTd" align="center"><s:property value="#d.ddesc"/></td>
				<td class="myTd" align="center"><a href="department_edit.action?did=<s:property value="#d.did"/>"><img src="images/edit.png"></a></td>
			    <td class="myTd" align="center"><a href="department_delete.action?did=<s:property value="#d.did"/>"><img src="images/trash.gif"></a></td>
			</tr>
		</s:iterator>
		</tbody>
	</table>
	<table style="width:800px;">
		<tr>
			<td align="right">
				<span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
				<span>总记录数：<s:property value="totalCount"/>每页显示：<s:property value="pageSize"/></span>&nbsp;&nbsp;
				<span> 
					 <s:if test="currPage!=1">
					 	<a href="department_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
						<a href="department_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp; 
					 </s:if>
					 <s:if test="currPage!=totalPage">
						<a href="department_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
						<a href="department_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
					 </s:if>
				</span>
			</td>
		</tr>
	</table>
</body>
</html>