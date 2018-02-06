<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<div class="container">
<jsp:include page ="/WEB-INF/views/module/top.jsp"/>

<h2>city Insert</h2>
<div class="row">
          <div class="col-sm-6 col-lg-6">
<form action="${pageContext.request.contextPath}/city/cityInsert" method="post">

   <table class="table table-striped" data-effect="fade">
      <tr>
         <td>도시 이름</td>
         <td><input name="city_name" type="text"/></td>
      </tr>
   </table>
   <input type="submit" value="추가">
</form>
</div>
</div>
</body>

<!-- Main Scripts-->
  <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>

  <!-- Bootstrap 3 has typeahead optionally -->
  <script src="${pageContext.request.contextPath}/resources/js/typeahead.min.js"></script>

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

</html>