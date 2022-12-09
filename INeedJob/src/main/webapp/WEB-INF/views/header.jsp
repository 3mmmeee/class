<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/header.css">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/default.css">
<fmt:setBundle basename="i18n/user" />
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
<header>
	<div class="headerBox">
		<a href="/INeedJob"><img class="header-logo"
			src="/INeedJob/image/logo.png"></a>

		<nav>
			<ul class="list">
				<li><a href="#">현업자</a>
					<ul class="list2">
						<li><a href="<c:url value='/empBoard/cat/1/${page}'/>">회사생활</a></li>
						<li><a href="<c:url value='/empBoard/cat/2/${page}'/>">이직
								& 커리어</a></li>
						<li><a href="<c:url value='/empBoard/cat/3/${page}'/>">지식공유</a></li>
						<li><a href="<c:url value='/empBoard/cat/4/${page}'/>">채용공고</a></li>
					</ul></li>
				<li><a href="#">취준생</a>
					<ul class="list2">
						<li><a href="<c:url value='/jhBoard/cat/5/${page}'/>">취준생활</a>
						</li>
						<li><a href="<c:url value='/jhBoard/cat/6/${page}'/>">스펙
								& 지식</a></li>
						<li><a href="<c:url value='/jhBoard/cat/7/${page}'/>">스터디</a>
						</li>
					</ul></li>
			</ul>
		</nav>

		<%--   	<div>
              <c:url var="actionURL" value='/empBoard/search/${page}' />
	  		 <form action="${actionURL}" id="searchForm">
                    <select type="name">
                       <option value="emp">현업자</option>
                       <option value="jh">취준생</option>
                    </select>
                    <input type="text" name="keyword">
                    <input type="submit" value="검색">
                 </form>
     </div> --%>

		<div>
			<!-- 로그인 하기 전 -->
			<c:if test="${empty userId}">
				<a href="<c:url value='/user/login'/>">
					<button type="button" class="Header_login_btn">
						<fmt:message key="LOGIN" />
					</button>
				</a>
				<a href="<c:url value='/user/empinsert'/>">
					<button type="button" class="Header_SignUp_btn">
						<fmt:message key="CREATE_AN_ACCOUNT_EMPLOYEE" />
					</button>
				</a>
				<a href="<c:url value='/user/jhinsert'/>">
					<button type="button" class="Header_SignUp_btn">
						<fmt:message key="CREATE_AN_ACCOUNT_JOBHUNTER" />
					</button>
				</a>
			</c:if>
			<!-- 로그인 한 후 -->
			<c:if test="${not empty userId && userId != 'admin'}">
				<button type="button" class="Header_login_btn">
					${sessionScope.userId} 님</button>
				<a href="<c:url value='/user/logout'/>">
					<button type="button" class="Header_SignUp_btn">
						<fmt:message key="SIGN_OUT" />
					</button>
				</a>
				<a href="<c:url value='/user/mypage/${userId}'/>">
					<button type="button" class="Header_SignUp_btn">
						<fmt:message key="MYPAGE" />
					</button>
				</a>

			</c:if>
			<!-- 관리자 페이지 이동 -->
			<c:if test="${userId == 'admin'}">
				<button type="button" class="Header_login_btn">${userId} 님
				</button>
				<a href="<c:url value='/user/logout'/>">
					<button type="button" class="Header_SignUp_btn">
						<fmt:message key="SIGN_OUT" />
					</button>
				</a>

				<a href="<c:url value='/user/list'/>" class="managerLogin"
					onclick="passWord()">
					<button type="button" class="Header_SignUp_btn">관리자 페이지</button>
				</a>
			</c:if>
		</div>
	</div>
</header>