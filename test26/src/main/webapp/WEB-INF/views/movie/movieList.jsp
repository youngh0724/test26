<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>Movie list</h2>
	목록 크기 : ${list.size()}

	<table border=1>
	<thead>
		<tr>
			<th>movie_id</th>
			<th>movie_name</th>
			<th>수정</th>
			<th>삭제</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="movie" items="${list}">
		<tr>
			<td>${movie.movieId}</td>
			<td>${movie.movieName}</td>
			<td><a href="${pageContext.request.contextPath}/movie/updateMovie?movieId=${movie.movieId}">수정</a>
			<td><a href="${pageContext.request.contextPath}/movie/deleteMovie?movieId=${movie.movieId}">삭제</a>
		</tr>
		</c:forEach>
	</tbody>
</table>

<a href="${pageContext.request.contextPath}/movie/insertMovie">영화 추가</a>


</body>
</html>