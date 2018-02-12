<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<jsp:include page="/WEB-INF/views/module/top.jsp" />

		<h2>country list</h2>
		<div class="row">
			<div class="col-sm-6 col-lg-6">				
				<p class="lead text-muted">페이지 당 출력행수 : ${rowPerPage },	현제 페이지 : ${currentPage }</p>				
				<form method="get" action="${pageContext.request.contextPath}/country/countryList">
				<input type="text" name="rowPerPage" >
				<input type="submit" value="출력할 행수">
				</form>

				<table class="table table-striped" data-effect="fade">
					<thead>
						<tr>
							<th>country_id</th>
							<th>country_name</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="country" items="${list}">
							<tr>
								<td>${country.countryId }</td>
								<td>${country.countryName }</td>
								<td><a
									href="${pageContext.request.contextPath}/country/countryUpdate?countryId=${country.countryId }">수정</a></td>
								<td><a
									href="${pageContext.request.contextPath}/country/countryDelete?countryId=${country.countryId }">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${currentPage > 1}">
				<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-1 }&rowPerPage=${rowPerPage }">이전 페이지</a>
				</c:if>
				<c:if test="${currentPage < lastPage }">
				<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+1 }&rowPerPage=${rowPerPage }">다음 페이지</a>
				</c:if>
			</div>
		</div>

		<a class="btn btn-default"
			href="${pageContext.request.contextPath}/country/countryInsert">국가
			추가</a> <a class="btn btn-default"
			href="${pageContext.request.contextPath}/">홈으로</a>



<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
