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
			<div class="col-sm-6 col-lg-6">

				<table style="width: 100%">
					<tr>
						<td>
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
							<!--SELECT COUNT OPTION 시작 -->
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
							<th>movieId</th>
							<th>movieName</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="movie" items="${list}">
							<tr>
								<td>${movie.movieId }</td>
								<td><a href="${pageContext.request.contextPath}/movie/movieFileList?movieId=${movie.movieId}">${movie.movieName}</a></td>
								<td><a href="${pageContext.request.contextPath}/movie/movieUpdate?movieId=${movie.movieId}">수정</a></td>
								<td><a href="${pageContext.request.contextPath}/movie/movieDelete?movieId=${movie.movieId}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<!-- 이전, 다음 버튼 시작 -->
				<div class="col-sm-12" style="margin-bottom: 10; text-align: center">
					<div>
						<a
							href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/movie/movieList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}</c:if>">
							<button type="button" class="btn btn-labeled btn-default">
								<span class="btn-label"> <i class="fa fa-arrow-left"></i>
								</span>이전
							</button></a> ${currentPage} <a
							href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/movie/movieList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}</c:if>">
							<button type="button" class="btn btn-labeled btn-default">
								다음<span class="btn-label btn-label-right"> <i class="fa fa-arrow-right"></i>
								</span>
							</button></a>
					</div>
					
					<div class="input-group" style="margin: auto;">
						<form class="navbar-form" role="search" action="${pageContext.request.contextPath}/movie/movieList" method="get">
							<input type="text" class="form-control" placeholder="Search" name="searchWord"> <span class="input-group-btn">
								<button class="btn btn-default" type="submit">검색</button>
							</span>
						</form>
					</div>
				</div>
				<!-- 이전, 다음 버튼 끝 -->
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/module/footer.jsp" />