<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jk" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<title>회원가입</title>
<script
   src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
   integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
   crossorigin="anonymous"></script>
</head>
<link
   href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
   rel="stylesheet"
   integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
   crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/INeedJob/css/user/insert.css">

<body>
   <div class="wrapper">
   		<a href="/INeedJob">
   			<img class="signUp_logo" src="/INeedJob/image/logo.png">
   		</a>
   		<span class="span">에 오신것을 환영합니다.</span>
   		
      <div class="container">
         
         <div class="insert_form">
            <form action="<c:url value='/user/empinsert'/>" method="post"
               id="empJoinForm" enctype="multipart/form-data">

               <!-- 아이디 -->
               <label for="userid"> <input class="form-control"
                  type="text" name="userId" id="userid"
                  title="<fmt:message key="USER_ID"/>" pattern="\w+"
                  placeholder="아이디" required>
               </label> <br>
               <!-- 비밀번호 -->
               <label for="password"> <input class="form-control"
                  type="password" name="userPw" id="password"
                  value="${USER.PASSWORD}"
                  title="<fmt:message key='PASSWORD_TITLE'/>"
                  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" placeholder="비밀번호"
                  required>
               </label> <br>
               <!-- 비밀번호 확인 -->
               <label for="password_re"> <input class="form-control"
                  type="password" id="password_re"
                  title="<fmt:message key='PASSWORD_RE_TITLE'/>"
                  pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
                  placeholder="비밀번호 확인" required>
               </label> <br>
               <!-- 이름 -->
               <label for="name"> <input class="form-control" type="text"
                  name="userName" id="name" value="${USER.name}" placeholder="이름"
                  required>
               </label> <br>
               <!-- 이메일 -->
               <label for="email"> <input class="form-control"
                  type="email" name="userEmail" id="email" value="${USER.address}"
                  placeholder="이메일" required>
               </label> <br>
               <!-- 소속 -->
               <label for="company"> <input class="form-control"
                  type="text" name="userCompany" id="company"
                  value="${USER.company}" placeholder="직장" required>
               </label> <br>
               <!-- 회사 인증 -->
               <div class="form-control">
                  <input type="file" id="company_check" name="file" required>
               </div>
               <div class="subTitle">직장인 권한 확인을 위해 사원증 이미지를 첨부하여 주십시오.</div>
               <!-- 회원 가입 button -->
               <%-- <a href="<c:url value='/user/empinsert'/>">
         <button type="button" class="login_btn">
         <fmt:message key="CREATE_AN_ACCOUNT_EMPLOYEE" />
         </a>
          --%>

               <input type="submit" class="insert_btn"
                  value="<fmt:message key="JOIN"/>">
            </form>
         </div>

      </div>
   </div>
</body>

</html>