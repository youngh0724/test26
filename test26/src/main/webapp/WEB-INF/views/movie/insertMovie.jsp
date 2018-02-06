<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="../resources/jquery-3.3.1.min.js"></script>
<title>Insert title here</title>

</head>
<body>
<h1>movie add</h1>

	<form id = "insertMovie" action="${pageContext.request.contextPath}/movie/insertMovie" method="post">
		<table border=1>
			<thead>
				<tr>
					<th>movie_name</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" name="movieName" id="movieName">
				</td>
			</tbody>
							
		</table>	
		<button type="button" id="insert-btn">영화 추가</button>
	</form>
	<script>

	$("#insert-btn").click(function(){
	    $('form').submit();	 
	    
	});
	</script>
</body>
</html>