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
        <div class="row">
          <div class="col-sm-6 col-lg-6">
            <p class="lead text-muted"> 목록 크기 : ${list.size()}</p>

				<!--SELECT COUNT OPTION 시작 -->
				<div style="margin-bottom: 10;">
					<select name="rowPerPage" onchange="location.href=this.value">
						<option value="#">보여줄 개수 선택</option>
						<option value="${pageContext.request.contextPath}/book/bookList?rowPerPage=5">5개 보여주기</option>
						<option value="${pageContext.request.contextPath}/book/bookList?rowPerPage=10">10개 보여주기</option>
						<option value="${pageContext.request.contextPath}/book/bookList?rowPerPage=20">20개 보여주기</option>
					</select><br>
				</div>
				<!--SELECT COUNT OPTION 끝 -->

				<table class="table table-striped" data-effect="fade">
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
            <div>
			<c:if test="${currentPage>1}">
				<a href="${pageContext.request.contextPath}/book/bookList?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
			</c:if>
			${currentPage}
			<c:if test="${currentPage<lastPage}">
				<a href="${pageContext.request.contextPath}/book/bookList?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
			</c:if>
		</div>
          </div>
          </div>

		<a class="btn btn-default"
         href="${pageContext.request.contextPath}/book/bookInsert">책 추가</a> 
         <a class = "btn btn-default"
         href="${pageContext.request.contextPath}/">메인 홈 리스트</a>
   
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
