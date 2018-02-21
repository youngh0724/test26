<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>

<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>Movie File List</h2>
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-6 col-lg-6">
				
				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>Movie File ID</th>
							<th>Movie ID
							<th>Movie name</th>						
							<th>File name</th>
							<th>File ext</th>
							<th>File size</th>							
						</tr>
					</thead>
					<tbody>
						<c:forEach var="mf" items="${movieAndMovieFile.list}">
							<tr>
								<td>${mf.movieFileId }</td>
								<td>${movieAndMovieFile.movieId }</td>
								<td>${movieAndMovieFile.movieName }</td>								
								<td>${mf.fileName}</td>
								<td>${mf.fileExt}</td>
								<td>${mf.fileSize}</td>																								
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 이전, 다음 버튼 끝 -->
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/module/footer.jsp" />