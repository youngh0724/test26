<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../resources/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h3>아이돌 수정</h3>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form action="${pageContext.request.contextPath}/idol/idolModify"
					method="post">
					<input type="hidden" name="idolId" value="${Idol.idolId}">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>이름</td>
							<td><input type="text" name="idolName" id="idolName"
								value="${Idol.idolName}"></td>
						</tr>
					</table>
					<input id="update" Type="button" value="수정">
				</form>
				<script>
					$('#update').click(function() {
						if ($('#idolName').val() == '') {
							alert('아이돌 이름을 입력하세요');
							$('#IdolName').focus();
						} else {
							$('form').submit();
						}
					})
				</script>
			</div>
		</div>
</body>

<jsp:include page="/WEB-INF/views/module/footer.jsp" />
