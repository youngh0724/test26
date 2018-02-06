<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <!-- Bootstrap css -->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.techie.css" rel="stylesheet">

	<title>Home</title>
	
</head>
<body>
<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

</div>

<script type="text/javascript" src="resources/js/bootstrap.js"></script>

</body>

<!-- Main Scripts-->
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  <!-- Bootstrap 3 has typeahead optionally -->
  <script src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>

</html>
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>