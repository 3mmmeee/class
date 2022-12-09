<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<%@ taglib prefix="jk" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jobhunter Search</title>
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
				<c:url var="actionURL" value='/jhBoard/search/${page}' />
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
	</div>
	<%@ include file="/WEB-INF/views/footer.jsp"%>



















	<div class="row">
		<div class="col-1g-12">
	<%-- 	<form action="<c:url value='/jhBoard/search/1'/>" > --%>
	<c:url var="actionURL" value='/jhBoard/search/1'/>
	<form action="${actionURL}" id="searchForm">

				<select type="name">
					<option value="T">제목</option>		
					<!-- <option value="C">내용</option>
					<option value="U">작성자</option>  -->
				</select> 
				<input type="text" name="keyword">

				<input type="submit" value="<fmt:message key="SEARCH"/>"> 
			</form>
		</div>
	</div> 
	<table border="1">
		<tr>
			<th>jh_id</th>
			<th>user_id</th>
			<th>jh_board_title</th>
			<th>jh_insert_date</th>
			<th>jh_read_count</th>
		</tr>
		<c:forEach var="jhBoard" items="${jhBoardList}">
			<tr>
				<td>${jhBoard.jhId}</td>
				<td>${jhBoard.userId}</td>
				<td>${jhBoard.jhBoardTitle}</td>
				<td>${jhBoard.jhInsertDate}</td>
				<td>${jhBoard.jhReadCount}</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>