<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <!-- Bootstrap css -->

<title>Insert title here</title>
</head>
<body>
   <div class="container">
     <jsp:include page ="/WEB-INF/views/module/top.jsp"/>
      
      <h2>Movie List</h2>
        <div class="row">
          <div class="col-sm-6 col-lg-6">
            <p class="lead text-muted"> 목록 크기 : ${list.size()}</p>
	          
	          				<!--SELECT COUNT OPTION 시작 -->
			<div style="margin-bottom: 10;">
				<select name="pagePerRow" onchange="location.href=this.value">
					<option value="#">보여줄 개수 선택</option>
					<option
						value="${pageContext.request.contextPath}/movie/movieList?pagePerRow=5">5개
						보여주기</option>
					<option
						value="${pageContext.request.contextPath}/movie/movieList?pagePerRow=10">10개
						보여주기</option>
					<option
						value="${pageContext.request.contextPath}/movie/movieList?pagePerRow=20">20개
						보여주기</option>
				</select><br>
			</div>
			<!--SELECT COUNT OPTION 끝 -->                 
            
            <table class="table table-striped" data-effect="fade">
              <thead>
                <tr>
               <th>movie_id</th>
               <th>movie_name</th>
               <th>수정</th>
               <th>삭제</th>
            </tr>
              </thead>
              <tbody>
                <c:forEach var="movie" items="${list}">
               <tr>
                  <td>${movie.movieId }</td>
                  <td>${movie.movieName }</td>
                  <td><a
                     href="${pageContext.request.contextPath}/movie/movieUpdate?movieId=${movie.movieId}">수정</a></td>
                  <td><a
                     href="${pageContext.request.contextPath}/movie/movieDelete?movieId=${movie.movieId}">삭제</a></td>

               </tr>
            </c:forEach>
              </tbody>
            </table>
          </div>        

			<div class="col-sm-12" style="margin-bottom: 10;">
				<div>
					<a href="<c:if test="${currentPage>1}">${pageContext.request.contextPath}/movie/movieList?currentPage=${currentPage-1}&pagePerRow=${pagePerRow}</c:if>"><button type="button" class="btn btn-labeled btn-default">
							<span class="btn-label"> <i class="fa fa-arrow-left"></i>
							</span>이전</button></a> 
					<a href="<c:if test="${currentPage<lastPage}">${pageContext.request.contextPath}/movie/movieList?currentPage=${currentPage+1}&pagePerRow=${pagePerRow}</c:if>"><button type="button" class="btn btn-labeled btn-default">
						    다음<span class="btn-label btn-label-right"> <i class="fa fa-arrow-right"></i>
							</span></button></a>
				</div>
			</div>
		<!-- 이전, 다음 버튼 .. -->
	</div>
	
	<div>
      <a class="btn btn-default"
         href="${pageContext.request.contextPath}/movie/movieInsert">영화 추가</a> 
         <a class = "btn btn-default"
         href="${pageContext.request.contextPath}/">메인 홈 리스트</a>
    </div>
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

