<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="../resources/css/bootstrap.css">
	<script src="../resources/jquery-3.3.1.min.js"></script>
	
</head>
<body>

	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>member insert form</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form
					action="${pageContext.request.contextPath}/member/memberInsert"
					method="post">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>아이디</td>
							<td><input id="memberId" name="memberId" type="text" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input id="memberPw" name="memberPw" type="text" /></td>
						</tr>
						<tr>
							<td>권한</td>
							<td><input id="memberLevel" name="memberLevel" type="text" /></td>
						</tr>
					</table>
					<input id="memberInsert" type="button" value="회원가입">
				</form>
				<script type="text/javascript" src="../resources/js/bootstrap.js"></script>

				<script>
					$('#memberInsert').click(function() {
						if ($('#memberId').val() == '') {
							alert('아이디를 입력하세요');
							$('#memberId').focus();
						} else if ($('#memberPw').val() == '') {
							alert('비밀번호를 입력하세요');
							$('#memberPw').focus();
						} else {
							$('form').submit();
						}
					})
				</script>
			</div>
		</div>
	</div>
</body>

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

