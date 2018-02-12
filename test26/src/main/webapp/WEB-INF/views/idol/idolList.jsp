<%@page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<title>Insert title here</title>
</head>
<body>
	<!-- container 시작 -->
	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>아이돌 리스트</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">
				<p class="lead text-muted">페이지 당 출력행수 : ${rowPerPage },	현제 페이지 : ${currentPage }</p>				
				<form method="get" action="${pageContext.request.contextPath}/idol/idolList">
				<input type="text" name="rowPerPage" >
				<input type="submit" value="출력할 행수">
				</form>
				
				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th scope="row">idolId</th>
							<th>idolName</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="I" items="${list}">
							<tr>
								<td>${I.idolId }</td>
								<td>${I.idolName }</td>
								<td><a
									href="${pageContext.request.contextPath}/idol/idolUpdate?idolId=${I.idolId}">수정</a></td>
								<td><a
									href="${pageContext.request.contextPath}/idol/idolDelete?idolId=${I.idolId}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage-1 }&rowPerPage=${rowPerPage }">이전 페이지</a>
				</c:if>
				<c:if test="${currentPage < lastPage }">
				<a href="${pageContext.request.contextPath}/idol/idolList?currentPage=${currentPage+1 }&rowPerPage=${rowPerPage }">다음 페이지</a>
				</c:if>
			</div>
		</div>
		<a class="btn btn-default" href="${pageContext.request.contextPath}/idol/idolInsert">아이돌 추가</a> 
		<a class="btn btn-default" href="${pageContext.request.contextPath}/">메인홈 리스트</a>
	

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
