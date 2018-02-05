<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 아이돌 등록 -->
<h3>아이돌 등록</h3>
<form action="${pageContext.request.contextPath}/idol/idolInsert" method="post">
	<table border="1">
		<tr>
		<td>아이돌 이름</td>
		<td><input type="text" name="idolName"></td>
		</tr>
	</table>
	<input Type="submit" value="등록">
</form>
</body>
</html>