<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />
	</div>
			<meta http-equiv='refresh' content='2;url=${pageContext.request.contextPath}/login/login'>
	
	<img style="display: block; margin-left: auto; margin-right: auto;" src="${pageContext.request.contextPath}/resources/image/sessionError.png">

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>