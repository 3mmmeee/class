<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css" href="/INeedJob/css/user/userlist.css">
<link rel="stylesheet" type="text/css" href="/INeedJob/css/common/default.css">
</head>
<script>
    var result = '${result}';
    
    if(result === "deleteFalse") {
       alert("비밀번호를 다시 입력해주세요.");
    }
 </script>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>
<div class="wrapper">
   <div class="deletecontainer">
      <h1>
         <span class="deleteTitle">삭제</span>
      </h1>
   </div>
   <form method="post" action="<c:url value='/user/delete'/>">
      <div>
         <label for="userId">아이디</label>
         <input type="text" id="userId" name="userId" value="${user.userId}" readonly/>
      </div>
      <div>
         <label for="userPw">비밀번호</label>
         <input type="password" id="userPw" name="userPw"/>
      </div>
      
      <div class="delete_btn">
         <button type="submit" ><fmt:message key="EXIT_USER"/></button>
   
      <a href="<c:url value='/user/login'/>">
         <button type="reset" ><fmt:message key="CANCEL"/></button>
      </a>      
      </div>
      </form>
</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>