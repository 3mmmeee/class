<%@ page contentType="text/html; charset=utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/user/login.css">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/default.css">
</head>
<SCRIPT>
<!-- 관리자 페이지 확인 패스워드 -->
   function passWord() {
      var managerPw = 1;
      var pass1 = prompt('비밀번호를 입력해 주세요', 'password'); // 초기시 암호 물어보는 멘트
      while (managerPw < 3) {
         if (!pass1)
            history.go(-1);
         if (pass1.toLowerCase() == "****") { // 암호지정
            alert('관리자 확인 완료'); // 암호가 맞았을때 나오는 멘트
            // window.open('http://'); // 이동할 웹페이지 지정 - 새창으로 뜰때
            location.href = '/myapp/user/login'; // 이동할 웹페이지 지정 - 현재창에서 이동

            break;
         }
         managerPw += 1;
         var pass1 = prompt('비밀번호를 잘못 입력했습니다.', 'password'); // 암호가 틀렸을때 멘트
      }
      if (pass1.toLowerCase() != "password" & managerPw == 3)
         history.go(-1);
      return " ";
   }
</SCRIPT>
<body>
	<div class="wrapper">
		<div class="Title_logo">
			<a href="/INeedJob"> <img class="loginLogo"
				src="<c:url value='/image/logo.png'/>">
			</a>
		</div>

		<div class="container">

			<c:if test="${empty sessionScope.userId}">
				<div class="login_form">
					<form action="<c:url value='/user/login'/>" method="post">

						<input type="text" name="userId" placeholder="ID"
							class="form-control"><br> <input type="password"
							name="userPw" placeholder="Password" class="form-control"><br>

						<button type="submit" class="loginPage_Login_btn">
							<fmt:message key="SIGN_IN" />
						</button>
					</form>

				</div>
				<!-- 회원가입 페이지로 이동 -->
				<div class="CREATE_AN_ACCOUNT">

					New to I Need Job? <strong>I Need You!</strong><br>
					<br> <a href="<c:url value='/user/empinsert'/>">
						<button type="button" class="loginPage_SignUp_btn">
							<fmt:message key="CREATE_AN_ACCOUNT_EMPLOYEE" />
						</button>
					</a>

					<div class="jhinsert-margin">
						<a href="<c:url value='/user/jhinsert'/>">
							<button type="button" class="loginPage_SignUp_btn">
								<fmt:message key="CREATE_AN_ACCOUNT_JOBHUNTER" />
							</button>
						</a>
					</div>

				</div>
			</c:if>
		</div>
	</div>
</body>
</html>