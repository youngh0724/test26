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
     <jsp:include page ="/WEB-INF/views/module/top.jsp"/>
      
      <h2>Book List</h2>
		<div class="row" style="margin-bottom:30;">
			<div class="col-sm-6 col-lg-6">
				<p class="lead text-muted">목록 크기 : ${list.size()}</p>
				<p class="lead text-muted">검색</p>
				
				<div class="input-group">
				<form class="navbar-form" role="search" action="${pageContext.request.contextPath}/book/bookList" method="get">
				<input type="text" class="form-control" placeholder="Search" name="searchWord">
				<span class="input-group-btn">
				<button class= "btn btn-default" type="submit">검색</button>	
				</span>		
				</form>	
				</div>
				
       			<div>
		<a class="btn btn-default"
         href="${pageContext.request.contextPath}/book/bookInsert">책 추가</a>     
  	    </div>
  	    
				<!--SELECT COUNT OPTION 시작 -->
				<div style="margin-bottom: 10;">
					<select name="rowPerPage" onchange="location.href=this.value">
						<option value="#">보여줄 개수 선택</option>
						<option
							value="${pageContext.request.contextPath}/book/bookList?rowPerPage=5">5개
							보여주기</option>
						<option
							value="${pageContext.request.contextPath}/book/bookList?rowPerPage=10">10개
							보여주기</option>
						<option
							value="${pageContext.request.contextPath}/book/bookList?rowPerPage=20">20개
							보여주기</option>
					</select><br>
				</div>
				<!--SELECT COUNT OPTION 끝 -->

				<table class="table table-striped"  data-effect="fade" >
					<thead>
						<tr>
							<th>bookId</th>
							<th>bookName</th>
							<th>수정</th>
							<th>삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${list}">
							<tr>
								<td>${book.bookId }</td>
								<td>${book.bookName }</td>
								<td><a
									href="${pageContext.request.contextPath}/book/bookUpdate?bookId=${book.bookId}">수정</a></td>
								<td><a
									href="${pageContext.request.contextPath}/book/bookDelete?bookId=${book.bookId}">삭제</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			<!-- 이전, 다음 버튼 시작 -->
			<div class="col-sm-12"  style="margin-bottom: 10; text-align: center">
				<div>
					<a href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/book/bookList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}</c:if>"><button type="button" class="btn btn-labeled btn-default">
							<span class="btn-label"> <i class="fa fa-arrow-left"></i>
							</span>이전</button></a> 
							${currentPage} 
					<a href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/book/bookList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}</c:if>"><button type="button" class="btn btn-labeled btn-default">
						    다음<span class="btn-label btn-label-right"> <i class="fa fa-arrow-right"></i>
							</span></button></a>
				</div>
			</div>
			<!-- 이전, 다음 버튼 끝 -->
		</div>
		</div>
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

