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
	<form action="film!update" method="post">
	<input name="f.id" type="hidden" value="<s:property value="f.id"/>" />
	<table border="1">
		<tr>
			<td>片名</td>
			<td><input name="f.name" type="text" value="<s:property value="f.name"/>"/></td>
		</tr>
		<tr>
			<td>导演</td>
			<td><input name="f.director" type="text" value="<s:property value="f.director"/>"/></td>

		</tr>
		<tr>
			<td>票价</td>
			<td><input name="f.price" type="text" value="<s:property value="f.price"/>"/></td>
			
		</tr>
		<tr>
		<td>上映时间</td>
		<td>
			<input name="f.pubdate" type="text" value="<s:property value="f.pubdate"/>"/>
		</td>
		</tr>
		<tr><td>出品公司</td>
		<td>
			<input name="f.company" type="text" value="<s:property value="f.company"/>"/>
		</td>
		</tr>
	</table>
	<input value="更新" type="submit"/>
	<input value="返回" type="button" onclick="backLast()"/>
	
	</form>
	
	<script type="text/javascript">
		function backLast() {
			window.history.back();
		}
	</script>
</body>
</html>
