<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                      
                      <li></li>
                    </ul>
                  </li>
                </ul>
                <form class="navbar-form navbar-right" role="search">
                  <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                  </div>
                </form>
              </div>
              <!-- /.navbar-collapse -->
            </nav>

          </div>
          </div>