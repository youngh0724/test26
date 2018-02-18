<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- linkRoot -->
<jsp:include page="/WEB-INF/views/inc/linkRoot.jsp"></jsp:include>
<!-- end linkRoot -->
<style>
body {
	font-family: "Roboto", sans-serif
}
.co-wid {
	width: 50px;
}
.w3-bar-block .w3-bar-item {
	padding: 16px;
	font-weight: bold
}
</style>
<title>Insert title here</title>
</head>
<body>

	<!-- navbar -->
	<jsp:include page="/WEB-INF/views/inc/navbar.jsp"></jsp:include>
	<!-- end navbar -->

	<div class="w3-main" style="margin-left: 250px;">

		<!-- header -->
		<jsp:include page="/WEB-INF/views/inc/header.jsp"></jsp:include>
		<!-- end header -->

		<div class="w3-container" style="padding: 32px">
			
				<h2>Country List</h2>
				<div class="w3-bar">
				<button class="w3-button w3-cyan w3-medium w3-border w3-round-large" onclick="location.href='${pageContext.request.contextPath}/country/countryInsert' ">도시 추가</button>
				<span class="w3-right">				
				<select class="w3-select" name="rowPerPage" onchange="location.href=this.value">
					<option value="#" disabled selected>페이지당 출력 건수</option>
					<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=5">5개 보여주기</option>
					<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=10">10개 보여주기</option>
					<option value="${pageContext.request.contextPath}/country/countryList?rowPerPage=20">20개 보여주기</option>
				</select>
				</span>
				</div>
			<br>
			<table class="w3-table-all w3-centered w3-hoverable w3-xlarge">
					<thead>
						<tr class="w3-light-grey">
							<th class="co-wid">countryId</th>
							<th>countryName</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="country" items="${list}">
							<tr>
								<td>${country.countryId }</td>
								<td>${country.countryName }</td>
								<td><a href="${pageContext.request.contextPath}/country/countryUpdate?countryId=${country.countryId}">수정</a></td>
								<td><a href="${pageContext.request.contextPath}/country/countryDelete?countryId=${country.countryId}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>	

		</div>
		<div class="w3-center" style="padding-bottom: 25px;">
			<div class="w3-bar w3-xlarge" style="padding-bottom: 25px;">
				<a href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}</c:if>" class="w3-button">&laquo;</a>
				<c:forEach var="page" begin="1" end="${lastPage}" step="1">								
					<a href="${pageContext.request.contextPath}/country/countryList?currentPage=${page}&rowPerPage=${rowPerPage}" class="w3-button">${page}</a>
				</c:forEach>
				<a href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/country/countryList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}</c:if>" class="w3-button">&raquo;</a>
			</div><br>
			<div class="w3-bar search-form">
				<form class="" action="${pageContext.request.contextPath}/country/countryList" method="get">
				<div class="w3-bar w3-xlarge">
					<input type="text" class="search-input" placeholder="Search" name="searchWord">
					<button class="search-button" type="submit">검색</button>
					</div>
				</form>
			</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="/WEB-INF/views/inc/footer.jsp"></jsp:include>
		<!-- end footer -->

	</div>
</body>
</html>