<%@ page contentType="text/html; charset=utf-8"
	trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fmt:setBundle basename="i18n/user" />
<html>

<head>
<title>I Need Job</title>
</head>
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/user/login.css">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/default.css">
<link rel="stylesheet" type="text/css"
	href="/INeedJob/css/common/home.css">

<jsp:include page="header.jsp" />
<body>
	<div class="wrapper">
		<!-- 광고 -->
		<div>
			<img class="ad2_img" src="/INeedJob/image/ad2.png" />
		</div>

		<!-- 리스트 -->
		<div class="ListBox">
			<!--현업자 리스트 -->
			<div class="ListBox2">
				<div class="Main_list_title">
					<span>회사생활</span> <img
						src="<c:url value='/image/office-building.png'/>">
				</div>

				<div class="Main_empList">
					<ul class="Main_emp_box1">
						<c:forEach var="empBoard" items="${empBoardList}">
							<li class="Main_empList2">
								<div>
									<div class="Main_empListBox2">${empBoard.userId}</div>
									<div class="Main_empListBox2">${empBoard.empInsertDate}</div>
								</div>
								<div class="Main_empTitle">
									<a
										href='<c:url value="/empBoard/details/${categoryId}/${empBoard.empId}/${page}"/>'>
										${empBoard.empBoardTitle} </a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>


			<!--취준생 리스트 -->
			<div class="ListBox3">
				<div class="Main_list_title">
					<span>취준생활</span> <img src="<c:url value='/image/employment.png'/>">
				</div>

				<div class="Main_empList">
					<ul class="Main_emp_box1">
						<c:forEach var="jhBoard" items="${jhBoardList}">
							<li class="Main_empList2">
								<div>
									<div class="Main_empListBox2">${jhBoard.userId}</div>
									<div class="Main_empListBox2">${jhBoard.jhInsertDate}</div>
								</div>
								<div class="Main_empTitle">
									<a
										href='<c:url value="/jhBoard/details/${categoryId}/${jhBoard.jhId}/${page}"/>'>
										${jhBoard.jhBoardTitle} </a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>

		<!-- 책광고 -->
		<div class="bookBox">
				<img src="/INeedJob/image/Java_Book.jpg"> 
				<img class="jsp_book" src="/INeedJob/image/JSP_Book.jpg">
				<img src="/INeedJob/image/HTML_Book.jpg">
		</div>
		<div class="bookTitle">
			<span class="javaTitle">혼자 공부하는 자바</span>
			<span class="jspTitle">성낙현의 JSP <br>
				  자바 웹 프로그래밍</span>
			<span class="htmlTitle"> HTML+CSS+자바스크립트 <br>
			         웹 표준의 정석</span>
		</div>
		
		<!-- 광고 -->
		<div>
			<img class="ad5_img" src="/INeedJob/image/ad5.jpg" />
		</div>


	</div>
</body>
<jsp:include page="footer.jsp" />
</html>