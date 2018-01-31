<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>country list</h2>
	목록 크기 : ${list.size()}
<table border=1>
	<thead>
		<tr>
			<th>country_id</th>
			<th>country_name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="country" items="${list}">
		<tr>
			<td>${country.countryId }</td>
			<td>${country.countryName }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>




</body>
</html>