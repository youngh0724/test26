<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

	<h3>아이돌 수정</h3>
	<div class="row">
          <div class="col-sm-6 col-lg-6">
	<form action="${pageContext.request.contextPath}/idol/idolModify"
		method="post">
				<input type="hidden" name="idolId" value="${Idol.idolId}">
		<table class="table table-striped" data-effect="fade">
			<tr>
				<td>이름</td>
				<td><input type="text" name="idolName" value="${Idol.idolName}"></td>
			</tr>
		</table>
		<input Type="submit" value="수정">
	</form>
	</div>
	</div>
</body>
<!-- Main Scripts-->
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  <!-- Bootstrap 3 has typeahead optionally -->
  <script src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

</html>