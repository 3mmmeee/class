<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
   crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/INeedJob/css/user/withdraw.css">
<link rel="stylesheet" type="text/css" href="/INeedJob/css/common/default.css">
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
   crossorigin="anonymous"></script>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<title>회원 탈퇴</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>
<body>
<div class="wrapper">
   <div class="container">
      <div class="deleteTitle""><h1>I Need Job, I Need YOU</h1> 
      회원 탈퇴</div>

      <div class="delete-form">
      <form method="post" action="<c:url value='/user/delete'/>">
            
      <!-- 아이디 -->
   <div class="form-floating mb-3">
        <input type="text" name="userId" class="form-control" id="userId" 
        value="${user['userId']}"
        placeholder="아이디" readonly>
        <label for="userId"><fmt:message key="USER_ID"/></label> 
    </div>
    
    <!-- 비밀번호 -->
    <div class="form-floating mb-3">
        <input type="password" name="userPw" class="form-control" id="userPw"
         pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" 
         placeholder="Password">
         <label for="userPw"><fmt:message key="USER_PW"/></label>
   </div>
               
               <button type="submit" class="withdraw-btn">
                  <fmt:message key="EXIT_USER" />
               </button>

               <a href="<c:url value="/"/>">
               <button class="withdraw-btn" type="button">
               <fmt:message key="CANCEL"/></button></a>
      </form>
      </div>
   </div>
</div>
</body>

<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>