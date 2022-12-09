<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jk" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업준비생 게시글 목록</title>
</head>
<link rel="stylesheet"
	href="<c:url value='/css/empboard/empBoardList.css'/>">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/default.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
<fmt:setBundle basename="i18n/user" />
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div class="wrapper">
		${message}
		<!-- 광고 -->
		<div class="ad">
			<img class="ad6_img" src="/INeedJob/image/ad8.png" />
		</div>

		<!-- 제목 -->
		<div class="title">
			<span>${categoryName}</span>
			<c:if test="${categoryId == 5}">
				<img src="<c:url value='/image/employment.png'/>">
			</c:if>
			<c:if test="${categoryId == 6}">
				<img src="<c:url value='/image/spec.png'/>">
			</c:if>
			<c:if test="${categoryId == 7}">
				<img src="<c:url value='/image/study.png'/>">
			</c:if>
		</div>

		<c:if test="${not empty userId}">
			<div class="empLine">
				<div class="empInsertBtn1">
					<a href='<c:url value="/jhBoard/insert/${categoryId}"/>'>
						<button id="empInsertBtn2" type="button">
							<img class="empPencil" src="<c:url value='/image/pencil.png'/>">
							글쓰기
						</button>
					</a>
				</div>

				<!-- 검색 -->
				<div class="SearchBox">
					<c:url var="actionURL" value='/jhBoard/search/${page}' />
					<form action="${actionURL}" class="SearchBox_1">
						<input type="text" name="keyword" placeholder="검색">
						<%-- 페이징처리 추후   <input type="hidden" name='pageNum' value="${} --%>
						<input type="submit" value="SEARCH">
					</form>
				</div>
			</div>
		</c:if>

		<c:if test="${empty userId}">
			<!-- 검색 -->
			<div class="empLine">
				<!-- 검색 -->
				<div>
					<c:url var="actionURL" value='/jhBoard/search/${page}' />
					<form action="${actionURL}" class="SearchBox_1">
						<input type="text" name="keyword" placeholder="검색">
						<%-- 페이징처리 추후   <input type="hidden" name='pageNum' value="${} --%>
						<input type="submit" value="SEARCH">
					</form>
				</div>
			</div>
		</c:if>

		<!-- 리스트 -->
		<div class="empListBox1">
			<ul class="empList1">
				<c:forEach var="jhBoard" items="${jhBoardList}">

					<li class="empList2">
						<div>
							<div class="empListBox2">${jhBoard.userId}</div>
							<div class="empListBox2">${jhBoard.jhInsertDate}</div>
							<div id="empLookUp">
								<img class="empEye" src="<c:url value='/image/view.png'/>">
								<div id="empRead">${jhBoard.jhReadCount}</div>
							</div>
						</div>
						<div id="empTitle">
							<a
								href='<c:url value="/jhBoard/details/${categoryId}/${jhBoard.jhId}/${page}"/>'>
								${jhBoard.jhBoardTitle} </a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>

		<!-- 페이징처리 -->
		<div id="pageBox">
			<jk:paging nowPage="${page}" categoryId="${categoryId}"
				totalPageCount="${totalPageCount}" />
		</div>


	</div>
</body>
<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>