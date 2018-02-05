<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css">
	<script src="../resoursces/jquery-3.3.1.min.js"></script>
</head>
<body>
<h2>country list</h2>
	목록 크기 : ${list.size()}
<a href="${pageContext.request.contextPath}/country/countryInsert">국가명 추가</a>
<div class="container">
<table class="table table-striped table-hover table-bordered">
	<thead>
		<tr>
			<th>country_id</th>
			<th>country_name</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="country" items="${list}">
		<tr>
			<td>${country.countryId }</td>
			<td>${country.countryName }</td>
			<td><a href="${pageContext.request.contextPath}/country/countryUpdate?countryId=${country.countryId }">수정</a></td>
			<td><a href="${pageContext.request.contextPath}/country/countryDelete?countryId=${country.countryId }">삭제</a></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</div>


<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
</body>
</html>