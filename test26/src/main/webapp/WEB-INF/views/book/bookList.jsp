<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">

<head>
<body>
<div class="container">
	<h2>book list</h2>
	목록 크기 : ${list.size()}
	<table border=1>
		<thead>
			<tr>
				<th>book_id</th>
				<th>book_name</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="book" items="${list}">
				<tr>
					<td>${book.book_id }</td>
					<td>${book.book_name }</td>
					<td><a class="btn btn-default" href="${pageContext.request.contextPath}book/bookUpdate?book_id=${book.book_id}">수정</a></td>
					<td><a class="btn btn-default" href="${pageContext.request.contextPath}book/bookDelete?book_id=${book.book_id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a class="btn btn-default" href="${pageContext.request.contextPath}book/bookInsert">책 추가</a>
	<a href="${pageContext.request.contextPath}/">메인 홈 리스트</a>
</div>
</body>

</html>
