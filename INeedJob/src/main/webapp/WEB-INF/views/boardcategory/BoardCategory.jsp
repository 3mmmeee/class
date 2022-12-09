<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>카테고리</title>
</head>
<body>
   <h3>카테고리</h3>
   <ul>

      <c:forEach var="list2" items="${list2}">
         <li>${list2.categoryName}</li>
      </c:forEach>


   </ul>
</body>
</html>