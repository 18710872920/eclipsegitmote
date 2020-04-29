<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>添加</title>
	<link rel="stylesheet" href="css/index.css" type="text/css" />
</head>
<body>
	<form action="AddServlet" method="post">
		<table border="1" class="t1">
			<tr>
				<td colspan="2s"><h1>添加商品</h1></td>
			</tr>
			<tr>
				<td>商品名称</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>商品价格:</td> 
				<td><input type="text" name="price"/></td> 
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="提交"/> 
					<input type="reset" value="清空"/>
				</td>	
			</tr>
		</table>
	</form>

</body>
</html>