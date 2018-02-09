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

<h2>city Update</h2>
<div class="row">
          <div class="col-sm-6 col-lg-6">
      <form action="${pageContext.request.contextPath}/city/cityUpdate" method="post">
      <table class="table table-striped" data-effect="fade">
         <tr>
            <td>cityId</td>
            <td><input type="text" name="cityId" value="${city.cityId }" readonly="readonly"></td>
         </tr>
         <tr>
            <td>cityName</td>
            <td><input type="text" name="cityName" value="${city.cityName }"></td>
         </tr>
      </table>
      <input type="submit" value="수정">
   </form>
     
 </div>
 </div>

</body>

<jsp:include page ="/WEB-INF/views/module/footer.jsp"/>

