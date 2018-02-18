<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<div id="myTop" class="w3-container w3-top w3-theme w3-large">
  <p><i class="fa fa-bars w3-button w3-teal w3-hide-large w3-xlarge" onclick="w3_open()"></i>
  <span id="myIntro" class="w3-hide">W3.CSS: Introduction</span></p>
</div>

<header class="w3-container w3-theme" style="padding:32px 32px">
  <h1 class="w3-xxxlarge">E.T Project</h1>
  
  				<c:set var="login" value="${loginMember}"></c:set>
				<c:if test="${empty login}">
				<div class="w3-right">
					<a type="button" class="w3-button w3-green" href="${pageContext.request.contextPath}/login/login">로그인</a>
					<a type="button" class="w3-button w3-green" href="${pageContext.request.contextPath}/member/memberInsert">회원가입</a>
				</div>							
				</c:if>
				<!-- 로그인버튼 끝 -->

				<!-- 로그아웃 버튼 시작 -->
				<c:set var="login" value="${loginMember}"></c:set>
				<c:if test="${!empty login}">
				<div class="w3-right">
					${login.memberId }님 로그인 중
					<a type="button" class="w3-button w3-green" href="${pageContext.request.contextPath}/login/logout">로그아웃</a>	
				</div>		
				</c:if>
				<!-- 로그아웃 버튼 끝 -->
  
</header>