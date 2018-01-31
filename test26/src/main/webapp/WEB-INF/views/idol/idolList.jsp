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
	<div>
		<c:forEach var="I" items="${list}">
			<div>${I.idolId}</div>
			<div>${I.idolName}</div>
		</c:forEach>
	</div>
</body>
</html>