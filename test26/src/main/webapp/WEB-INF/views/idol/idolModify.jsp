<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>아이돌 수정</h3>
<form action="${pageContext.request.contextPath}/idol/idolModify">
		<table border="1">
		<tr>
		<td>이름</td>
		<td><input type="text" name="idolNo" value="${Idol.idolName}"></td>
		</tr>
	</table>
	<input Type="submit" value="수정">
</form>
</body>
</html>