<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<fmt:setBundle basename="i18n/user" />
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" type="text/css" href="/INeedJob/css/user/mypage.css">
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>
<div class="wrapper">
   <div class="container">
           <div class="mypageTitle">
               <h1><fmt:message key="UPDATE_USER_INFO"/></h1>
                <span>${userId}님의 회원 정보를 수정합니다.</span>
         </div>
   
      <div class="mypageForm">
      <form action="<c:url value='/user/mypage'/>" method="post">
      
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
            value="${user.userPw}" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" 
            placeholder="Password">
            <label for="userPw"><fmt:message key="USER_PW"/></label>
      </div>
   
       <!-- 비밀번호 확인 -->
      <div class="form-floating mb-3">    
          <input type="password" name="password_re" class="form-control" id="password_re"
                 pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" required
                 placeholder="password">
           <label for="password_re">비밀번호 확인</label>
       </div>
   
      <!-- 이름 -->
      <div class="form-floating mb-3">
           <input type="text" name="userName" class="form-control" id="userName" 
                 value="${user.userName}" placeholder="이름">
            <label for="userName"><fmt:message key="USER_NAME"/></label>
      </div>
   
       <!-- 이메일 -->
       <div class="form-floating mb-3">
           <input type="email" name="userEmail" class="form-control" id="userEmail" 
                 value="${user.userEmail}" placeholder="이메일">
            <label for="userEmail"><fmt:message key="USER_EMAIL"/></label>
      </div>
       
      <!-- 회사 -->
      <c:if test="${!empty user.userCompany}">
         <div class="form-floating mb-3">
           <input type="text" name="userCompany" class="form-control" id="userCompany"
                 value="${user.userCompany}" placeholder="소속">
            <label for="userCompany"><fmt:message key="USER_COMPANY"/></label>
      </div>
      </c:if>
          <button type="submit" class="update_btn"><fmt:message key="SAVE"/></button>
      
      <div class="withdraw-btn">
         <a href="<c:url value='/user/delete/${userId}'/>" 
            style="float: right; color: #ced4da; text-decoration-line: none;">회원 탈퇴
         </a>
      </div>
      </form>
      </div>
   </div> 
</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>