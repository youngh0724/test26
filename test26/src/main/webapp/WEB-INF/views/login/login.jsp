<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">



<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>member Login Form</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form
					action="${pageContext.request.contextPath}/login/login"
					method="post">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>ID</td>
							<td><input id="memberId" name="memberId" type="text" value="guest"/></td>
						</tr>
						<tr>
							<td>PW</td>
							<td><input id="memberPw" name="memberPw" type="text" value="1234"/></td>
						</tr>
					</table>
					<input class="btn btn-default" id="login" type="button" value="login">
				</form>
			</div>
		</div>
	</div>
	<!-- Main Scripts-->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

	<!-- Bootstrap 3 has typeahead optionally -->
	<script
		src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>
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
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>