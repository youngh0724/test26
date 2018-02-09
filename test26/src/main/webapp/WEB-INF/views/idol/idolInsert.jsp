<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="../resources/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>
</head>
<body>

	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<!-- 아이돌 등록 -->
		<h3>아이돌 등록</h3>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form action="${pageContext.request.contextPath}/idol/idolInsert"
					method="post">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>아이돌 이름</td>
							<td><input type="text" name="idolName" id="idolName"></td>
						</tr>
					</table>
					<input id=insert Type="button" value="추가">
				</form>
				<script>
					$('#insert').click(function() {
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

