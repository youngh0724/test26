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
			<h2>팀원 소개</h2>

			<div class="w3-card-4 w3-white col-lg-3 col-sm-3">

				<div class="w3-container w3-center">
					<h3>팀장</h3>
					<header class="w3-container w3-blue">

						<img src="resources/image/Ryan.jpg" alt="Avatar"
							style="width: 80%">
					</header>

					<div class="w3-container">
						<h3>이영현</h3>
						<p>나이 : 29</p>
						<p>소속 : 2조</p>
						<p>역할 : 팀장</p>
						<p>소갯말 : 팀장 하기 싫었는데</p>
					</div>

				</div>

			</div>
			<div class="w3-card-4 w3-white col-lg-3 col-sm-3">

				<div class="w3-container w3-center">
					<h3>팀원</h3>
					<header class="w3-container w3-blue">

						<img src="resources/image/RoJin.png" alt="Avatar"
							style="width: 80%">
					</header>

					<div class="w3-container">
						<h3>박로진</h3>
						<p>나이 : 27살</p>
						<p>소속 : 2조</p>
						<p>역할 : 뿌릉</p>
						<p>소갯말 : 부릉부릉</p>
					</div>

				</div>

			</div>
			<div class="w3-card-4 w3-white col-lg-3 col-sm-3">

				<div class="w3-container w3-center">
					<h3>팀원</h3>
					<header class="w3-container w3-blue">

						<img src="resources/image/heartcat.jpg" alt="Avatar"
							style="width: 80%">
					</header>

					<div class="w3-container">
						<h3>박범진</h3>
						<p>나이 : 29살</p>
						<p>소속 : 2조</p>
						<p>역할 : 눈팅</p>
						<p>소갯말 : 가즈아ㅏㅏㅏㅏ</p>
					</div>

				</div>

			</div>
			<div class="w3-card-4 w3-white col-lg-3 col-sm-3">

				<div class="w3-container w3-center">
					<h3>팀원</h3>
					<header class="w3-container w3-blue">

						<img src="resources/image/minsang.jpg" alt="Avatar"
							style="width: 80%">
					</header>

					<div class="w3-container">
						<h3>안준철</h3>
						<p>나이 : 35살</p>
						<p>소속 : 2조</p>
						<p>역할 : 나이 많은 형</p>
						<p>소갯말 : 열심히는 핡게요 열심히만...</p>
					</div>

				</div>

			</div>




		</div>
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
		<!-- end footer -->

	</div>
</body>
</html>

