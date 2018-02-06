<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- Bootstrap css -->
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/bootstrap.techie.css" rel="stylesheet">
<div class="row">
<div class="col-sm-12 col-lg-12">


            <nav class="navbar navbar-inverse" role="navigation">
              <!-- Brand and toggle get grouped for better mobile display -->
              <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex2-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
              </div>

              <!-- Collect the nav links, forms, and other content for toggling -->
              <div class="collapse navbar-collapse navbar-ex2-collapse">
                <ul class="nav navbar-nav">
                 <!-- <li><a href="#">Link</a></li> 메뉴 생성 -->
                 
                 <!-- top 메뉴 리스트 시작 -->
                  <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">리스트 <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                      <li><a href="${pageContext.request.contextPath}/book/bookList">북 리스트</a></li>
                      <li class="divider"></li>
                      <li><a href="${pageContext.request.contextPath}/city/cityList">도시 리스트</a></li>
                      <li class="divider"></li>
                      <li><a href="${pageContext.request.contextPath}/country/countryList">국가 리스트</a></li>
                      <li class="divider"></li>
                      <li><a href="${pageContext.request.contextPath}/idol/idolList">아이돌 리스트</a></li>
                      <li class="divider"></li>
                      <li><a href="${pageContext.request.contextPath}/movie/movieList">영화 리스트</a></li>                      
                    </ul>
                  </li>
                  <!-- top 메뉴 리스트 끝 -->
                  
                  
                </ul>
                <!-- 로그인버튼 시작 -->
                <form class="navbar-form navbar-right">
                 <a class="btn btn-primary" href="#">login</a>
                </form>
                <!-- 로그인버튼 끝 -->
              </div>
              <!-- /.navbar-collapse -->
            </nav>

          </div>
          </div>