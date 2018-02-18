<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- linkRoot -->
<jsp:include page="/WEB-INF/views/inc/linkRoot.jsp"></jsp:include>
<!-- end linkRoot -->
<style>
body {
	font-family: "Roboto", sans-serif
}

.w3-bar-block .w3-bar-item {
	padding: 16px;
	font-weight: bold
}
</style>
<title>Insert title here</title>
</head>
<body>

	<!-- navbar -->
	<jsp:include page="/WEB-INF/views/inc/navbar.jsp"></jsp:include>
	<!-- end navbar -->

	<div class="w3-main" style="margin-left: 250px;">

		<!-- header -->
		<jsp:include page="/WEB-INF/views/inc/header.jsp"></jsp:include>
		<!-- end header -->

		<div class="w3-container" style="padding: 32px">
			<h2>콘택트 페이지</h2>

		

		</div>
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
		<!-- end footer -->

	</div>
</body>
</html>
