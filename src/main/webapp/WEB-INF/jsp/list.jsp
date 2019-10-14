<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="<%=request.getContextPath()%>/css/index_like1.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery-1.8.2.min.js">
</script>
<body>
<table>
	<tr>
	<td>编号</td>
	<td>产品名称</td>
	<td>产品价格</td>
	<td>售后百分比</td>
	</tr>
	<c:forEach items="${list }" var="w">
	<tr>
	<td>${w.gid }</td>
	<td>${w.gname }</td>
	<td>${w.age }</td>
	<td>${w.bfb }</td>
	</tr>
	</c:forEach>
	<tr>
		<td>
			<input type="button" value="首页" onclick="location='list?cpage=1'">
			<input type="button" value="上一页" onclick="location='list?cpage=${page.cpage-1}'">
			<input type="button" value="下一页" onclick="location='list?cpage=${page.cpage+1}'">
			<input type="button" value="尾页" onclick="location='list?cpage=${page.pages}'">
		</td>
	</tr>
</table>
</body>
</html>