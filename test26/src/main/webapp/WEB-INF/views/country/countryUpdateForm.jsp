<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>country update form</h2>

	<form action="${pageContext.request.contextPath}/country/countryUpdate" method="post">
		<table border=1>
			<tr>
				<td>country_id</td>
				<td><input type="text" name="countryId" value="${country.countryId }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>country_name</td>
				<td><input type="text" name="countryName" value="${country.countryName }"></td>
			</tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>