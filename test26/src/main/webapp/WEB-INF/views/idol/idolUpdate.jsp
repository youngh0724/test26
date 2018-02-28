<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<form action="${pageContext.request.contextPath}/idol/idolUpdate"
					method="post">
					<input type="hidden" name="idolId" value="${idol.idolId}">
					<table class="table table-striped" data-effect="fade">
						<tr>
							<td>이름</td>
							<td><input type="text" name="idolName" id="idolName"
								value="${idol.idolName}"></td>
						</tr>
						<tr>
							<td>첨부파일</td>
                            <td>
                            <c:forEach var="idolFileList" items="${idolAndIdolFile.list}">
                                ${idolFileList.idolFileName}
                                <input type="file" id="file" name="file">
                            </c:forEach>
                            </td>
						</tr>
					</table>
					<input id="update" Type="button" value="수정">
					<input id="delete" type="button" value="삭제">
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
<!-- Main Scripts-->
<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

<!-- Bootstrap 3 has typeahead optionally -->
<script
	src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>
<jsp:include page="/WEB-INF/views/module/footer.jsp" />

</html>