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
<h2>city list</h2>
	목록 크기 : ${list.size()}
<table border=1>
	<thead>
		<tr>
			<th>city_id</th>
			<th>city_name</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="city" items="${list}">
		<tr>
			<td>${city.cityId }</td>
			<td>${city.cityName }</td>
			<td><a href="${pageContext.request.contextPath}/city/updateCity?cityId=${city.cityId}">수정</a>
			<td><a href="${pageContext.request.contextPath}/city/deleteCity?cityId=${city.cityId}">삭제</a>
		</tr>
		</c:forEach>
	</tbody>
</table>

<a href="${pageContext.request.contextPath}/">메인 홈 리스트</a>


</body>
</html>