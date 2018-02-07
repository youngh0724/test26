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
            <table class="table table-striped" data-effect="fade">
              <thead>
                <tr>
               <th>book_id</th>
               <th>book_name</th>
               <th>수정</th>
               <th>삭제</th>
            </tr>
              </thead>
              <tbody>
                <c:forEach var="book" items="${list}">
               <tr>
                  <td>${book.book_id }</td>
                  <td>${book.book_name }</td>
                  <td><a
                     href="${pageContext.request.contextPath}/book/bookUpdate?book_id=${book.book_id}">수정</a></td>
                  <td><a
                     href="${pageContext.request.contextPath}/book/bookDelete?book_id=${book.book_id}">삭제</a></td>

               </tr>
            </c:forEach>
              </tbody>
            </table>
          </div>
          </div>
         
      <a class="btn btn-default"
         href="${pageContext.request.contextPath}/book/bookInsert">책 추가</a> 
         <a class = "btn btn-default"
         href="${pageContext.request.contextPath}/">메인 홈 리스트</a>
   
<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>
