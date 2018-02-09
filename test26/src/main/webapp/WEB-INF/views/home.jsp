<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
	
</head>
<body>
<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

<div class="row" style="height:100px">
<div class="col-sm-12 col-lg-12 " data-effect="slide-bottom">
            <p class="lead text-muted">팀원 소개</p>
            <!-- Thumbnails container -->
            <div class="row">
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/RoJin.png">
                  <div class="caption" style="height:300px">
                    <h3>박로진</h3>
                    <p>나이 : 27살</p>
                    <p>소속 : 2조</p>
                    <p>역할 : 뿌릉</p>
                    <p>소갯말 : 부릉부릉</p>
                   
                  </div>
                </div>
              </div>
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/heartcat.jpg">
                  <div class="caption" style="height:300px">
                    <h3>박범진</h3>
                    <p>나이 : 29살</p>
                    <p>소속 : 2조</p>
                    <p>역할 : 눈팅</p>
                    <p>소갯말 : 가즈아ㅏㅏㅏㅏ</p>
                    
                  </div>
                </div>
              </div>
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/minsang.jpg">
                  <div class="caption" style="height:300px">
                    <h3>안준철</h3>
                    <p>나이 : 35살</p>
                    <p>소속 : 2조</p>
                    <p>역할 : 나이 많은 형</p>
                    <p>소갯말 : 열심히는 핡게요 열심히만...</p>
                    
                  </div>
                </div>
              </div>
              <div class="col-lg-3 col-sm-3 ">
                <div class="thumbnail">
                  <img alt="avator" src="resources/image/Ryan.jpg">
                  <div class="caption" style="height:300px">
                    <h3>이영현</h3>
                    <p>나이 : 29</p>
                    <p>소속 : 2조</p>
                    <p>역할 : 팀장</p>
                    <p>소갯말 : 팀장 하기 싫었는데</p>
                    
                  </div>
                </div>
              </div>
              
          
              
              
              
            </div>
            <!-- /Thumbnails container -->
          </div>
        </div>
     
    



<script type="text/javascript" src="resources/js/bootstrap.js"></script>

</body>

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>