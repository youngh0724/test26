<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>country insert form</h2>
<form action="${pageContext.request.contextPath}/country/countryInsert" method="post">
	<table border=1>
		<tr>
			<td>국가명</td>
			<td><input name="countryName" type="text"/></td>
		</tr>
	</table>
	<input type="submit" value="입력">
</form>
</body>
</html>