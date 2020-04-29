<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改商品</title>
	<link rel="stylesheet" href="index.css" type="text/css"/>
</head>
<body>
	<form action="UpdateServlet" method="post"> 
	<table border="1" class="t1">
	
	<tr>
		<td colspan="2"><h1>修改商品信息</h1></td> 
	</tr>
	
	<tr>
		<td>商品编号:</td> 
		<td><input type="text" name="id" value="${goods.id}" 
		readonly="readonly"/></td> 
		</tr>
		<tr>
			<td>商品名称:</td> 
			<td><input type="text" name="name" value="${goods.name}"/></td> 
		</tr> 
		<tr>
			<td>商品价格:</td> 
			<td><input type="text" name="price" value="${goods.price}"/></td>
			 </tr>
			 <tr>
			 	<td colspan="2"> 
				 	<input type="submit" value="提交"/> 
				 	<input type="button" value="返回" onclick="history.go(-1)"/> 
			 	</td> 
			 </tr>
		</table> 
	</form>
</body>
</html>
















