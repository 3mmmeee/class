<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<link rel="stylesheet" type="text/css"
   href="/INeedJob/css/common/default.css">
<link rel="stylesheet" href='/INeedJob/css/jhboard/jhBoardView.css' />
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업준비생 글쓰기</title>
</head>
<body>
<%@ include file="/WEB-INF/views/header.jsp"%>
<div class="wrapper">
   <form action="<c:url value='/jhBoard/insert'/>" method="post" enctype="multipart/form-data">
        <div align="center">
         <img class="ad_img" src="/INeedJob/image/ad3.png" />
      </div>
       <div class="hr-sect">취업준비생 게시판 입력창</div>
      ${message}
      <table border="1">
         <c:forEach var="jhBoard" items="${categoryList}">

         </c:forEach>
            <tr>
            <th>카테고리</th>
            <td><input type="hidden" value="${categoryId}" name="categoryId">${categoryName}
            </td>
         </tr>
         <tr>
            <th>작성자</th>
            <td>${sessionScope.userId}
            <input type="hidden" name="userId" value="${userId}">
            </td>
         </tr>
         <tr>
            <th>제목</th>
            <td><input type="text" style="height: 30px; width: 1088px;" name="jhBoardTitle" required>
            </td>
         </tr>
         
         <tr>
            <th>내용</th>
            <td><input type="text" style="height: 300px; width: 1088px;" name="jhBoardContent" required>
            </td>
         </tr>
         <tr>
            <th>첨부파일</th>
            <td>
            <input type="file" name="file"></td>
         </tr>
      </table>
      
       <div align="center" class="click">
      <input type="submit" class="click_button_btn"  value="저 장"> 
      <input type="reset" class="click_button_btn"  value="취 소">
      </div>
   </form>
   </div>
   <%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>