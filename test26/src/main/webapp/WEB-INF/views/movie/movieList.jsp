<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

  <!-- Bootstrap css -->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.techie.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
   <div class="container">
     <jsp:include page ="/WEB-INF/views/module/top.jsp"/>
      
      <h2>Movie List</h2>
        <div class="row">
          <div class="col-sm-6 col-lg-6">
            <p class="lead text-muted"> 목록 크기 : ${list.size()}</p>
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
                     href="${pageContext.request.contextPath}/movie/updateMovie?movieId=${movie.movieId}">수정</a></td>
                  <td><a
                     href="${pageContext.request.contextPath}/movie/deleteMovie?movieId=${movie.movieId}">삭제</a></td>

               </tr>
            </c:forEach>
              </tbody>
            </table>
          </div>
          </div>
         
      <a class="btn btn-default"
         href="${pageContext.request.contextPath}/movie/insertMovie">영화 추가</a> 
         <a class = "btn btn-default"
         href="${pageContext.request.contextPath}/">메인 홈 리스트</a>
    </div>
   
    <!-- Main Scripts-->
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  <!-- Bootstrap 3 has typeahead optionally -->
  <script src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>
   
</body>
</html>