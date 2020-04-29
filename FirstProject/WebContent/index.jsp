<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>显示</title>
	<style type="text/css">
		table{
			border:1px solid pink;
			margin: 0 auto;
		}
		td{
			width:150px;
			border:1px solid pink;
			text-align:center;
		}
		
	</style>
</head>
<body>
	<table>
		<tr>
			<td>商品编号</td>
			<td>商品名称</td>
			<td>商品价格</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${goodsList}" var="item">
			<tr>
				<td>${item.id }</td> 
				<td>${item.name }</td> 
				<td>${item.price }</td> 
				<td><a href="DeleteServlet?id=${item.id }">删除</a>|<a 
				href="UpdateServlet?id=${item.id }">修改</a></td>
			</tr>
			</c:forEach>
			<tr>
				<td colspan="6" style="text-align: left;"><a href="add.jsp">添加商品 </a></td>
			</tr>
	</table>

</body>
</html>