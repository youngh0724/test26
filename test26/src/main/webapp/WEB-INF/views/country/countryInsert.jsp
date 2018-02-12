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

	<h2>country insert form</h2>
	<div class="row">
          <div class="col-sm-6 col-lg-6">
	<form action="${pageContext.request.contextPath}/country/countryInsert" method="post">
		<table class="table table-striped" data-effect="fade">
			<tr>
				<td>국가명</td>
				<td><input id="countryName" name="countryName" type="text"/></td>
			</tr>
		</table>
		<input id="update" type="button" value="추가">
	</form>	
	
	<script>
		$('#update').click(function(){
			if($('#countryName').val() == ''){
				alert('국가이름을 입력하세요');
				$('#countryName').focus();
			}else{
				$('form').submit();
			}
		})
		
	</script>
	</div>
	</div>
</body>


<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
