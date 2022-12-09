<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<%@ taglib prefix="jk" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EmpBoard Search</title>
</head>
<link rel="stylesheet"
	href="<c:url value='/css/empboard/empBoardSearch.css'/>">
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
		<!-- 광고 -->
		<div class="ad">
			<img class="ad7_img" src="/INeedJob/image/ad7.png" />
		</div>

		<div class="title">
			<span>현업자 검색 목록</span> <img src="<c:url value='/image/search.png'/>">
		</div>

		<!-- 검색창 -->
		<div class="empLine">
			<!-- 검색 -->
			<div >
				<c:url var="actionURL" value='/empBoard/search/${page}' />
				<form action="${actionURL}" class="SearchBox_1">
					<input type="text" name="keyword" placeholder="검색">
					<%-- 페이징처리 추후   <input type="hidden" name='pageNum' value="${} --%>
					<input type="submit" value="SEARCH">
				</form>
			</div>
		</div>

		<!-- 검색 리스트 -->
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
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>