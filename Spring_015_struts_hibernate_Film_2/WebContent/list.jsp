
<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电影列表</title>
<link href="css/global.css" rel="stylesheet" type="text/css" />
<link href="css/layout.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<table border="1">
		<tr>
			<td colspan="6">电影列表</td>
		</tr>
		<tr>
			<td>片名</td>
			<td>导演</td>
			<td>票价</td>
			<td>上映时间</td>
			<td>出品公司</td>
			<td>操作</td>
		</tr>
	
		<s:iterator value="list" var="f">
			<tr>
				
				<td><s:property value="#f.name"/></td>
				<td><s:property value="#f.director"/></td>
				<td><s:property value="#f.price"/></td>
				<td><s:property value="#f.pubdate"/></td>
				<td><s:property value="#f.company"/></td>
				<td>
					<input value="delete" type="button" onclick="skipToPage('film!delete?id=<s:property value="#f.id"/>')"/>
					<input value="update" type="button" onclick="skipToPage('film!updateInput?id=<s:property value="#f.id"/>')"/>
					<input value="detail" type="button" onclick="skipToPage('film!detail?id=<s:property value="#f.id"/>')"/>
				</td>
			</tr>
		</s:iterator>
			
			
		</tr>
	</table>
	
	<script type="text/javascript" src="js/function.js"></script>
</body>
</html>
