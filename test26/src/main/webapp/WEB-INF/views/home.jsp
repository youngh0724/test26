<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
 <!-- Bootstrap css -->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.techie.css" rel="stylesheet">

	<title>Home</title>
	
</head>
<body>
<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

<div class="row">
<div class="col-sm-12 col-lg-12 " data-effect="slide-bottom">
            <p class="lead text-muted">팀원 소개</p>
            <!-- Thumbnails container -->
            <div class="row">
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/RoJin.png">
                  <div class="caption">
                    <h3>박로진</h3>
                    <p>나이 : 27살</p>
                    <p>소속 : 2조</p>
                    <p>역할 : 맨날 빠짐</p>
                    <p>소갯말 : github 너무어려워요...</p>
                   
                  </div>
                </div>
              </div>
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/RoJin.png">
                  <div class="caption">
                    <h3>이름</h3>
                    <p>나이 : </p>
                    <p>소속 : 2조</p>
                    <p>역할 : </p>
                    <p>소갯말 : </p>
                    
                  </div>
                </div>
              </div>
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/RoJin.png">
                  <div class="caption">
                    <h3>이름</h3>
                    <p>나이 : </p>
                    <p>소속 : 2조</p>
                    <p>역할 : </p>
                    <p>소갯말 : </p>
                    
                  </div>
                </div>
              </div>
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/RoJin.png">
                  <div class="caption">
                    <h3>이름</h3>
                    <p>나이 : </p>
                    <p>소속 : 2조</p>
                    <p>역할 : </p>
                    <p>소갯말 : </p>
                    
                  </div>
                </div>
              </div>
              
          
              
              
              
            </div>
            <!-- /Thumbnails container -->
          </div>
        </div>
      </div>
    



<script type="text/javascript" src="resources/js/bootstrap.js"></script>

</body>

<!-- Main Scripts-->
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  <!-- Bootstrap 3 has typeahead optionally -->
  <script src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>

</html>
