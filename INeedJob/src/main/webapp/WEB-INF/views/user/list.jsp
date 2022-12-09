<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!-- 반복문을 사용하려고 하면 JSP 페이지 상단에 JSTL core 선언이 필요 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="/INeedJob/css/user/userlist.css">
<link rel="stylesheet" type="text/css" href="/INeedJob/css/common/default.css">
</head>
<%@ include file="/WEB-INF/views/header.jsp"%>
<body>
<div class="wrapper">
   <div class="UserList_container">
      <p class="list-line">승인 대기 목록</p>
      <table border=1 class="table table-hover">
         <tr>
            <th>No</th>
            <th>ID</th>
            <th>이름</th>
            <th>이메일</th>
            <th>소속</th>
            <th>권한</th>
         </tr>
            
            <c:forEach items="${userList}" var="user" varStatus="tableNum">
               <tr>
                  <td>
                       <a class="UserList" href="<c:url value='/user/details/${user.userId}'/>">
                           ${tableNum.count}</a></td>
                  <td>${user.userId}</td>
                  <td>${user.userName}</td>
                  <td>${user.userEmail}</td>
                  <td>${user.userCompany}</td>
                  <td>${user.userApproval}</td>
               </tr>
            
            </c:forEach>
      </table> 
   </div>
   
</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>

</html>