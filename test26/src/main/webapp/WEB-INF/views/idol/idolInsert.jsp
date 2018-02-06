<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

<!-- 아이돌 등록 -->
<h3>아이돌 등록</h3>
<div class="row">
          <div class="col-sm-6 col-lg-6">
<form action="${pageContext.request.contextPath}/idol/idolInsert" method="post">
	<table class="table table-striped" data-effect="fade">
		<tr>
		<td>아이돌 이름</td>
		<td><input type="text" name="idolName"></td>
		</tr>
	</table>
	<input Type="submit" value="등록">
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