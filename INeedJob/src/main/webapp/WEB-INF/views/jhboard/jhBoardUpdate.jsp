<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업준비생 게시글 업데이트</title>
</head>
<link rel="stylesheet" type="text/css"
   href="/INeedJob/css/common/default.css">
<link rel="stylesheet" href='/INeedJob/css/jhboard/jhBoardView.css' />
<body>
   <%@ include file="/WEB-INF/views/header.jsp"%>
   <div class="wrapper">
      <form action="<c:url value='/jhBoard/update'/>" method="post"
         enctype="multipart/form-data">
         <div align="center">
            <img class="ad_img" src="/INeedJob/image/ad4.png" />
         </div>
         <div class="hr-sect">취업준비생 게시글 수정</div>

         <table border="1">
            <c:forEach var="jhBoard" items="${categoryList}">

            </c:forEach>
            <tr>
               <th>카테고리</th>
               <td><input type="hidden" value="${categoryId}"
                  name="categoryId">${categoryName}</td>
            </tr>
            <tr>
               <th>작성자</th>
               <td>${sessionScope.userId}<input type="hidden" name="userId"
                  value="${sessionScope.userId}"> <input type="hidden"
                  name="jhId" value="${jhBoard.jhId}">
               </td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" name="jhBoardTitle"
                  style="height: 30px; width: 1088px;"
                  value="${jhBoard.jhBoardTitle}" required></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><input type="text" name="jhBoardContent"
                  style="height: 300px; width: 1088px;"
                  value="${jhBoard.jhBoardContent}" required></td>
            </tr>
            <tr>
               <th>첨부파일</th>
               <td>${jhBoard.jhFileName} <input type="file" name="file">
                  <input type="hidden" name="jhFileId" value="${jhBoard.jhFileId}">
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