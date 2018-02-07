<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Bootstrap css -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.techie.css"
	rel="stylesheet">
<div class="row">
	<div class="col-sm-12 col-lg-12">


		<nav class="navbar navbar-inverse" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex2-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-ex2-collapse">
				<ul class="nav navbar-nav">
					<!-- <li><a href="#">Link</a></li> 메뉴 생성 -->

					<!-- top 메뉴 리스트 시작 -->
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown">List <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a
								href="${pageContext.request.contextPath}/book/bookList">북리스트</a></li>
							<li class="divider"></li>

							<li><a
								href="${pageContext.request.contextPath}/city/cityList">도시리스트</a></li>
							<li class="divider"></li>

							<li><a
								href="${pageContext.request.contextPath}/country/countryList">국가리스트</a></li>
							<li class="divider"></li>

							<li><a
								href="${pageContext.request.contextPath}/idol/idolList">아이돌리스트</a></li>
							<li class="divider"></li>

							<li><a
								href="${pageContext.request.contextPath}/movie/movieList">영화리스트</a></li>
						</ul></li>
					<!-- top 메뉴 리스트 끝 -->

					<!-- contact 메뉴 시작 -->
					<li><a class="navbar-brand"
						href="${pageContext.request.contextPath}/contact/contactwork">Contact</a></li>
					<!-- contact 메뉴 끝 -->

				</ul>
				<!-- 로그인버튼 시작 -->
				<c:set var="login" value="${loginMember}"></c:set>
				<c:if test="${empty login}">
				<form class="navbar-form navbar-right">
						<div class="btn-group">
							<button class="btn btn-primary  dropdown-toggle"
								data-toggle="dropdown"> 로그인<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="${pageContext.request.contextPath}/login/login">로그인</a></li>
								
								<li class="divider"></li>
								<li><a href="">회원가입</a></li>
							</ul>
						</div>
		
					</form>
				
				</c:if>
				<!-- 로그인버튼 끝 -->

				<!-- 로그아웃 버튼 시작 -->
				<c:set var="login" value="${loginMember}"></c:set>
				<c:if test="${!empty login}">
					<form class="navbar-form navbar-right">

						<div class="btn-group">
							<button class="btn btn-success  dropdown-toggle username"
								data-toggle="dropdown">${loginMember.memberId }
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">내 정보</a></li>
								<li><a href="${pageContext.request.contextPath}/member/memberUpdate?memberNo=${loginMember.memberNo }">정보 수정</a></li>
								<li><a href="${pageContext.request.contextPath}/member/memberDelete?memberId=${loginMember.memberId }">회원탈퇴</a></li>
								<li class="divider"></li>
								<li><a href="${pageContext.request.contextPath}/login/logout">로그아웃</a></li>
							</ul>
						</div>

					</form>
				</c:if>
				<!-- 로그아웃 버튼 끝 -->

			</div>
			<!-- /.navbar-collapse -->
		</nav>

	</div>
</div>