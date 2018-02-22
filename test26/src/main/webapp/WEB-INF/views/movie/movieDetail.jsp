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

		<h2>Movie List</h2>
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-12 col-lg-12">

				<table style="width: 100%">
					<tr>
						<td>
						<!--SELECT COUNT OPTION 시작 -->
							<div>
								<select name="rowPerPage" onchange="location.href=this.value">
									<option value="#">보여줄 개수 선택</option>
									<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=5">5개 보여주기</option>
									<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=10">10개 보여주기</option>
									<option value="${pageContext.request.contextPath}/movie/movieList?rowPerPage=20">20개 보여주기</option>
								</select><br>
							</div>
						</td>

						<td style="margin: auto; text-align: right;">
							<div>
								<a class="btn btn-default" href="${pageContext.request.contextPath}/movie/movieInsert">영화 추가</a>
							</div>
						</td>
					</tr>
					<!--SELECT COUNT OPTION 끝 -->
				</table>
				
				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>movieFileId</th>
							<th>movieId</th>
							<th>movieName</th>
							<th>fileName</th>
							<th>fileExt</th>
							<th>fileSize</th>									
							<th>다운로드</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="file" items="${movieAndMovieFile.list}">
							<tr>
								<td>${file.movieFileId }</td>
								<td>${movieAndMovieFile.movieId }</td>
								<td>${movieAndMovieFile.movieName }</td>
								<td><a href="${pageContext.request.contextPath}/movie/movieFileDown?movieFileId=${file.movieFileId }">${file.fileName }</a></td>
								<td>${file.fileExt }</td>
								<td>${file.fileSize }</td>													
								<td><a href="${pageContext.request.contextPath}/movie/movieFileDown?movieFileId=${file.movieFileId}">다운로드</a></td>
								<td><a href="${pageContext.request.contextPath}/movie/movieDeleteFile?movieFileId=${file.movieFileId}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-default" href="${pageContext.request.contextPath}/movie/movieList">리스트로 돌아가기</a>
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/module/footer.jsp" />