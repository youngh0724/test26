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

		<h2>article List</h2>
		<div class="row" style="margin-bottom: 30;">
			<div class="col-sm-6 col-lg-6">

				<table style="width: 100%">
					<tr>
						<td>
							<div>
								<select name="rowPerPage" onchange="location.href=this.value">
									<option value="#">보여줄 개수 선택</option>
									<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=5">5개 보여주기</option>
									<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=10">10개 보여주기</option>
									<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=20">20개 보여주기</option>
								</select><br>
							</div>
						</td>

						<td style="margin: auto; text-align: right;">
							<!--SELECT COUNT OPTION 시작 -->
							<div>
								<a class="btn btn-default" href="${pageContext.request.contextPath}/article/articleInsert">article 추가</a>
							</div>
						</td>
					</tr>
					<!--SELECT COUNT OPTION 끝 -->
				</table>
				
				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>article_file_id</th>
							<th>article_id</th>
							<th>file_name</th>
							<th>file_ext</th>
							<th>file_size</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="articlefile" items="${list}">
							<tr>
								<td>${articlefile.articleFileId }</td>
								<td>${articlefile.articleId }</td>
								<td>${articlefile.fileName }</td>
								<td>${articlefile.fileExt }</td>
								<td>${articlefile.fileSize }</td>
								<td><a href="${pageContext.request.contextPath}/article/articleFileUpdate?articleId=$${articlefile.articleFileId }">수정</a></td>
								<td><a href="${pageContext.request.contextPath}/article/articleFileDelete?articleId=$${articlefile.articleFileId }">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div>
					<a class="btn btn-default" href="${pageContext.request.contextPath}/article/articleList">articleList로 돌아가기</a>
				</div>
			</div>
		</div>
		
		<jsp:include page="/WEB-INF/views/module/footer.jsp" />