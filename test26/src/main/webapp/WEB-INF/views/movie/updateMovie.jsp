<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css">
<script src="../resources/jquery-3.3.1.min.js"></script>
</head>
<body>
<h2>movie update form</h2>

	<form action="${pageContext.request.contextPath}/movie/movieUpdate" method="post">
		<table border=1>
			<tr>
				<td>movie_id</td>
				<td><input type="text" name="movieId" value="${movie.movieId }" readonly="readonly"></td>
			</tr>
			<tr>
				<td>movie_name</td>
				<td><input type="text" id="movieName" name="movieName" value="${movie.movieName }"></td>
			</tr>
		</table>
		<input id="update" type="button" value="수정">
	</form>
	<script type="text/javascript" src="../resources/js/bootstrap.js"></script>
	
	<script>
		$('#update').click(function(){
			if($('#movieName').val() == ''){
				alert('영화 제목을 입력하세요');
				$('#movieName').focus();
			}else{
				$('form').submit();
			}
		})
		
	</script>
</body>
</html>