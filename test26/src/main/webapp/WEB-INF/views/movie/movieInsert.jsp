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

<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

	<h2>movie insert form</h2>
	<div class="row">
          <div class="col-sm-6 col-lg-6">
	<form action="${pageContext.request.contextPath}/movie/movieInsert" method="post" enctype="multipart/form-data">
		<table class="table table-striped" data-effect="fade">
			<tr>
				<td>영화명</td>
				<td><input id="movieName" name="movieName" type="text"/></td>
			</tr>
			<tr>
				<td>파일</td>
				<td><input type="file" name="files" multiple="multiple"/></td>
			</tr>
		</table>
		<input id="insert" type="button" value="추가">
	</form>	
	
	<script>
		$('#insert').click(function(){
			if($('#movieName').val() == ''){
				alert('영화이름을 입력하세요');
				$('#movieName').focus();
			}else{
				$('form').submit();
			}
		})
		
	</script>
	</div>
	</div>
</body>


<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
