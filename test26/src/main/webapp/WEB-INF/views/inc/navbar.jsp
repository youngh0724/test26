<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<nav class="w3-sidebar w3-bar-block w3-collapse w3-animate-left w3-card" style="z-index:3;width:250px;" id="mySidebar">
  <a class="w3-bar-item w3-button w3-border-bottom w3-large" href="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/image/w3schools.png" style="width:80%;"></a>
  <a class="w3-bar-item w3-button w3-hide-large w3-large" href="javascript:void(0)" onclick="w3_close()">Close <i class="fa fa-remove"></i></a>
  <a class="w3-bar-item w3-button w3-teal" href="${pageContext.request.contextPath}/">Home</a> 
  <div>
    <a class="w3-bar-item w3-button" onclick="myAccordion('list')" href="javascript:void(0)"> View List</a>
    <div id="list" class="w3-hide">
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/book/bookList">책 리스트</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/city/cityList">도시 리스트</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/country/countryList">나라 리스트</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/idol/idolList">아이돌 리스트</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/movie/movieList">영화 리스트</a>
    </div>
  </div>
 	<c:set var="login" value="${loginMember}"></c:set>
	<c:if test="${!empty login}">
  <div>
    <a class="w3-bar-item w3-button" onclick="myAccordion('info')" href="javascript:void(0)"> View Info</a>
    <div id="info" class="w3-hide">
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/member/memberInfo?memberNo=${loginMember.memberNo }">내 정보</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/member/memberUpdate?memberNo=${loginMember.memberNo }">정보 수정</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/member/memberDelete?memberId=${loginMember.memberId }">회원탈퇴</a>
      <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/login/logout">로그아웃</a>  
    </div>
  </div>
  </c:if>
  <a class="w3-bar-item w3-button" href="${pageContext.request.contextPath}/contact/contactwork">CONTACT</a>
</nav>

<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" id="myOverlay"></div>