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

		<h2>movie Update</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<form action="${pageContext.request.contextPath}/movie/movieUpdate"
					method="post">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>movieId</td>
							<td><input type="text" name="movieId" value="${movie.movieId }"
								readonly="readonly"></td>
						</tr>
						<tr>
							<td>movieName</td>
							<td><input type="text" id="movieName" name="movieName"
								value="${movie.movieName }"></td>
						</tr>
					</table>
					<input id="update" type="button" value="수정">
				</form>
				<script>
					$('#update').click(function() {
						if ($('#movieName').val() == '') {
							alert('영화 이름을 입력하세요');
							$('#movieName').focus();
						} else {
							$('form').submit();
						}
					})
				</script>
			</div>
		</div>
</body>

<jsp:include page="/WEB-INF/views/module/footer.jsp" />