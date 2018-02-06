<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>city Update</h2>

      <form action="${pageContext.request.contextPath}/city/cityUpdate" method="post">
      <table border=1>
         <tr>
            <td>city_id</td>
            <td><input type="text" name="city_id" value="${city.city_id }" readonly="readonly"></td>
         </tr>
         <tr>
            <td>city_name</td>
            <td><input type="text" name="city_name" value="${city.city_name }"></td>
         </tr>
      </table>
      <input type="submit" value="수정버튼">
   </form>
      <div>
         <a href="${pageContext.request.contextPath}/"><button type="button" class="btn btn-success active">메인 홈 리스트</button></a>
      </div>
 

</body>
</html>