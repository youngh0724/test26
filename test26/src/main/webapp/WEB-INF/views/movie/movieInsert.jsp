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

<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>
<h1>movie add</h1>
<div class="row">
          <div class="col-sm-6 col-lg-6">

	<form id = "insertMovie" action="${pageContext.request.contextPath}/movie/movieInsert" method="post">
		 <table class="table table-striped" data-effect="fade">
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
		<button type="button" id="insert-btn">추가</button>
	</form>
		  </div>
</div>
	<script>

	$("#insert-btn").click(function(){
	    $('form').submit();	 
	    
	});
	</script>
</body>
<!-- Main Scripts-->
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  <!-- Bootstrap 3 has typeahead optionally -->
  <script src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

</html>
