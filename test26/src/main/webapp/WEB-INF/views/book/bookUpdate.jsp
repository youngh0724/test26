<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../resources/jquery-3.3.1.min.js"></script>
</head>
<body>

	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>book Update</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form action="${pageContext.request.contextPath}/book/bookUpdate"
					method="post">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>bookId</td>
							<td><input type="text" name="bookId" value="${book.bookId }"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>bookName</td>
							<td><input type="text" id="bookName" name="bookName"
								value="${book.bookName }"></td>
						</tr>
					</table>
					<input id="update" type="button" value="수정">
				</form>
				<script>
					$('#update').click(function() {
						if ($('#bookName').val() == '') {
							alert('책 이름을 입력하세요');
							$('#bookName').focus();
						} else {
							$('form').submit();
						}
					})
				</script>
			</div>
		</div>
</body>

<jsp:include page="/WEB-INF/views/module/footer.jsp" />