<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/user/update.css">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/default.css">
</head>
<%@ include file="/WEB-INF/views/header.jsp"%>
<body>
	<div class="wrapper">
		<div class="container">
			<div class="updateTitle">
				<h1>${userId}님의 회원정보수정</h1>
			</div>
			<br>
			<div class="form-floating mb-3">
				<div class="updateForm">
					<form action="<c:url value='/user/update'/>" method="post">

						<!-- 아이디 -->
						<div class="form-floating mb-3">
							<input type="text" name="userId" class="form-control" id="userId"
								value="${user['userId']}" placeholder="아이디" readonly> <label
								for="userId"><fmt:message key="USER_ID" /></label>
						</div>


						<!-- 이름 -->
						<div class="form-floating mb-3">
							<input type="text" name="userName" class="form-control"
								id="userName" value="${user.userName}" placeholder="이름">
							<label for="userName"><fmt:message key="USER_NAME" /></label>
						</div>

						<!-- 이메일 -->
						<div class="form-floating mb-3">
							<input type="email" name="userEmail" class="form-control"
								id="userEmail" value="${user.userEmail}" placeholder="이메일">
							<label for="userEmail"><fmt:message key="USER_EMAIL" /></label>
						</div>

						<!-- 회사 -->
						<c:if test="${!empty user.userCompany}">
							<div class="form-floating mb-3">
								<input type="text" name="userCompany" class="form-control"
									id="userCompany" value="${user.userCompany}" placeholder="소속">
								<label for="userCompany"><fmt:message key="USER_COMPANY" /></label>
							</div>
						</c:if>



						<!-- 업로드 파일 -->

						<c:if test="${!empty fileId}">
							<div class="form-floating mb-3"
								style="border: 1px solid #ced4da; border-radius: 0.375rem; transition: border-color .15s ease-in-out, box-shadow .15s ease-in-out;">
								<img class="approval-img" src="/INeedJob/file/${fileId}">
							</div>
						</c:if>

						<!-- 권한 -->
						<div class="form-check form-switch form-check-reverse">
							<c:if test="${user.userApproval == 'N'}">
								<input type="checkbox" name="userApproval" value="N"
									class="form-check-input" id="flexSwitchCheckReverse">
								<input type="checkbox" name="userApproval" value="Y"
									class="form-check-input" id="flexSwitchCheckReverse">
							</c:if>
							<c:if test="${user.userApproval == 'Y'}">
								<input type="checkbox" name="userApproval" value="Y"
									class="form-check-input" id="flexSwitchCheckReverse">

								<input type="checkbox" name="userApproval" value="N"
									class="form-check-input" id="flexSwitchCheckReverse">
								<label class="form-check-label" for="flexSwitchCheckReverse"></label>
							</c:if>


							</label>

						</div>

						<button type="submit" class="update_btn">
							<fmt:message key="SAVE" />
						</button>
					</form>
					<div class="withdraw-btn">
						<a href="<c:url value='/user/details/${userId}'/>"
							style="float: right; color: #ced4da; text-decoration-line: none;">뒤로가기
						</a>
					</div>
					<%-- 
               <div class="update_btn">
                  <input type="submit" value="<fmt:message key="SAVE"/>"> 
                  <a href="<c:url value='/user/details/${userId}'/>"> 
                  
                  <input type="button" value="<fmt:message key="CANCEL"/>"></a>
               </div> --%>


				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>

</html>