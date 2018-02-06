<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h2>book Insert</h2>
<form action="${pageContext.request.contextPath}/book/bookInsert" method="post">
   <table border=1>
      <tr>
         <td>책 이름</td>
         <td><input name="book_name" type="text"/></td>
      </tr>
   </table>
   <input type="submit" value="추가버튼">
</form>
</body>
</html>