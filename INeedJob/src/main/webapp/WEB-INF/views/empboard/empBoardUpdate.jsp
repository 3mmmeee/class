<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현직자 게시글 업데이트</title>
</head>
<link rel="stylesheet" type="text/css"
   href="/INeedJob/css/common/default.css">
<link rel="stylesheet" href='/INeedJob/css/jhboard/jhBoardView.css' />
<body>
   <%@ include file="/WEB-INF/views/header.jsp"%>
   <div class="wrapper">
   <div align="center">
            <img class="ad_img" src="/INeedJob/image/ad4.png" />
         </div>
   <div class="hr-sect">현직자 게시글 수정</div>
   <c:url var="actionURL" value='/empBoard/update' />
   <form action="${actionURL}" method="post" enctype="multipart/form-data">
   
      <table border="1">
<c:forEach var="jhBoard" items="${categoryList}">

            </c:forEach>
            
         <tr>
            <th>카테고리</th>
            <td><input type="hidden" value="${categoryId}"
               name="categoryId">${categoryName} <input type="hidden"
               name="empId" value="${empBoard.empId}">
         </tr>
         <tr>
            <th>작성자</th>
            <td>${sessionScope.userId}<input type="hidden" name="userId"
               value="${sessionScope.userId}"> <input type="hidden"
                  name="empId" value="${empBoard.empId}">
            </td>
         
         </tr>
         <tr>
            <th>제목</th>
            <td><input type="text" name="empBoardTitle"
            style="height: 30px; width: 1088px;"
               value="${empBoard.empBoardTitle}" required></td>
         </tr>
         <tr>
            <th>내용</th>
            <td><input type="text" name="empBoardContent"
               style="height: 300px; width: 1088px;"
               value="${empBoard.empBoardContent}"></td>
         </tr>
         <tr>
            <th>첨부파일</th>
            <td>${empBoard.empFileName} <input type="file" name="empFile">
               <input type="hidden" name="empFileId" value="${empBoard.empFileId}">
            </td>
         </tr>
            </table>
            <div align="center" class="click">
         <input type="submit" class="click_button_btn" value="저 장"> <input
               type="reset" class="click_button_btn" value="취 소">
         </div>
   
   </form>
   </div>
   <script>
      var result = '${result}';
      if (result === 'updateOK') {
         alert("수정되었습니다.");
      }
   </script>
</body>
   <%@ include file="/WEB-INF/views/footer.jsp"%>
</html>