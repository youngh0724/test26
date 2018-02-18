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
			
			<div class="w3-container w3-half w3-margin-top">
			
			<header class="w3-container w3-teal">
				<h2>member Login Form</h2>
			</header>

				<form class="w3-container w3-card-4" action="${pageContext.request.contextPath}/login/login" method="post">

					<p><input class="w3-input" type="text" id="memberId" name="memberId" type="text" value="guest" style="width: 90%" required><label>Name</label></p>
					<p><input class="w3-input" type="password" id="memberPw" name="memberPw" type="text" value="1234" style="width: 90%" required> <label>Password</label></p>				

					<p><button class="w3-button w3-section w3-teal w3-ripple" id="login">Log in</button></p>

				</form>
			</div>
			</div>
			<!-- footer -->
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
		<!-- end footer -->
	</div>
	
		<script>
		$('#login').click(function(){
			if($('#memberId').val() == ''){
				alert('아이디를 입력하세요');
				$('#memberId').focus();
			} else if($('#memberPw').val() == ''){
				alert('비밀번호를 입력하세요');
				$('#memberPw').focus();
			}else{
				$('form').submit();
			}
		})
		
	</script>
</body>
</html>
