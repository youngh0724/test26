<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="resources/css/bootstrap.css">
	<script src="resoursces/jquery-3.3.1.min.js"></script>
</head>
<body>



<a href="${pageContext.request.contextPath}/book/bookList">북 리스트</a><br>
<a href="${pageContext.request.contextPath}/city/cityList">도시 리스트</a><br>
<a href="${pageContext.request.contextPath}/country/countryList">국가 리스트</a><br>
<a href="${pageContext.request.contextPath}/idol/idolList">아이돌 리스트</a><br>
<a href="${pageContext.request.contextPath}/movie/movieList">영화 리스트</a><br>
<P>  The time on the server is ${serverTime}. </P>
<script type="text/javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>
