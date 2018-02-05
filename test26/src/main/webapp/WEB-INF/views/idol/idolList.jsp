<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>아이돌 리스트</h2>
	top : ${list.size()}
<table border=1>
	<thead>
		<tr>
			<th>idolId</th>
			<th>idolName</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="I" items="${list}">
		<tr>
			<td>${I.idolId }</td>
			<td>${I.idolName }</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
	<a href="${pageContext.request.contextPath}/idol/idolInsert">등록</a>
	<a href="#">삭제</a>







