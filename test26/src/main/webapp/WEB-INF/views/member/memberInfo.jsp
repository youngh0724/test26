<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<script src="../resources/jquery-3.3.1.min.js"></script>
</head>
<body>

<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

<h2>회원 정보</h2>

<div class="row">
     <div class="col-sm-6 col-lg-6">	
		<table class="table table-striped" data-effect="fade">
			<tr>
				<th>회원 번호</th>
				<th>아이디</th>				
				<th>권한</th>
			</tr>
			<tr>
				<td>${loginMember.memberNo }</td>
				<td>${loginMember.memberId }</td>
				<td>${loginMember.memberLevel }</td>				
		</table>				
		<a class="btn btn-default" href="${pageContext.request.contextPath}/">홈으로</a>
	</div>	
</div>
</div>	
	<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
		
</body>


<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
