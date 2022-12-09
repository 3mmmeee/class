<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="jk" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현업자 게시글 목록</title>
</head>
<link rel="stylesheet"
	href="<c:url value='/css/empboard/empBoardList.css'/>">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/default.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">isplay=swap" rel="stylesheet">
<fmt:setBundle basename="i18n/user" />
<body>
	<%@ include file="/WEB-INF/views/header.jsp"%>
	<div class="wrapper">
		${message}
		<!-- 광고 -->
		<div class="ad">
			<img src="/INeedJob/image/ad6.png" />
		</div>
		<!-- 제목 -->
		<div class="title">
			<span>${categoryName}</span>
			<c:if test="${categoryId == 1}">
				<img src="<c:url value='/image/office-building.png'/>">
			</c:if>
			<c:if test="${categoryId == 2}">
				<img src="<c:url value='/image/career-promotion.png'/>">
			</c:if>
			<c:if test="${categoryId == 3}">
				<img src="<c:url value='/image/book.png'/>">
			</c:if>
			<c:if test="${categoryId == 4}">
				<img src="<c:url value='/image/headhunting.png'/>">
			</c:if>
		</div>

		<c:if test="${sessionScope.approval == 'Y'}">
			<div class="empLine">

				<div class="empInsertBtn1">
					<a href='<c:url value="/empBoard/insert/${categoryId}"/>'>

						<button id="empInsertBtn2" type="button">
							<img class="empPencil" src="<c:url value='/image/pencil.png'/>">
							글쓰기
						</button>

					</a>
				</div>

				<!-- 검색 -->
				<div class="SearchBox">
					<c:url var="actionURL" value='/empBoard/search/${page}' />
					<form action="${actionURL}" class="SearchBox_1">
						<input type="text" name="keyword" placeholder="검색">
						<%-- 페이징처리 추후   <input type="hidden" name='pageNum' value="${} --%>
						<input type="submit" value="SEARCH">
					</form>
				</div>
			</div>
		</c:if>

		<c:if test="${sessionScope.approval == 'N' || empty userId}">
			<div class="empLine">
				<!-- <div class="SearchBox"> -->
					<!-- 검색 -->
					<c:url var="actionURL" value='/empBoard/search/${page}' />
					<form action="${actionURL}" class="SearchBox_1">
						<input type="text" name="keyword" placeholder="검색">
						<%-- 페이징처리 추후   <input type="hidden" name='pageNum' value="${} --%>
						<input type="submit" value="SEARCH">
					</form>
				
			</div>
		</c:if>

		<div class="empListBox1">
			<ul class="empList1">
				<c:forEach var="empBoard" items="${empBoardList}">

					<li class="empList2">
						<div>
							<div class="empListBox2">${empBoard.userId}</div>
							<div class="empListBox2">${empBoard.empInsertDate}</div>
							<div id="empLookUp">
								<img class="empEye" src="<c:url value='/image/view.png'/>">
								<div id="empRead">${empBoard.empReadCount}</div>
							</div>
						</div>
						<div id="empTitle">
							<a
								href='<c:url value="/empBoard/details/${categoryId}/${empBoard.empId}/${page}"/>'>
								${empBoard.empBoardTitle} </a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>

		<div id="pageBox">
			<jk:paging nowPage="${page}" categoryId="${categoryId}"
				totalPageCount="${totalPageCount}" />
		</div>
	</div>
</body>

<%@ include file="/WEB-INF/views/footer.jsp"%>
</html>