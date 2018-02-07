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
<h1>회원 정보 수정 화면</h1>
	<form action="${pageContext.request.contextPath}/login/login" method="post">
		<table border = 1>
			<tr>
				<th>회원 번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>권한</th>
			</tr>
			<tr>
				<td><input type="text" name=memberNo value="${member.memberNo }" readonly="readonly"></td>
				<td><input type="text" name=memberId value="${member.memberId }"></td>
				<td><input type="text" name=memberPw></td>
				<td><input type="text" name=memberLevel value="${member.memberLevel }" readonly="readonly"></td>
		</table>
				<input type="button" id="mUpdate-btn" value="회원 정보 수정">
	</form>
	<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
	
	<script>
		$('#mUpdate-btn').click(function(){
			$('form').submit();
			})		
		
	</script>
	
</body>
</html>