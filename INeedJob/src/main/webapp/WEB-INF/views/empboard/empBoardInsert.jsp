<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>현직자 글쓰기</title>
</head>
<link rel="stylesheet" type="text/css"
   href="/INeedJob/css/common/default.css">
<link rel="stylesheet" href='/INeedJob/css/jhboard/jhBoardView.css' />
<body>
   <%@ include file="/WEB-INF/views/header.jsp"%>
   <div class="wrapper">
      <c:url var="actionURL" value='/empBoard/insert' />
      <form action="${actionURL}" method="post"
         enctype="multipart/form-data">
         <div align="center">
            <img class="ad_img" src="/INeedJob/image/ad4.png" />
         </div>
         <div class="hr-sect">현업자 게시판 입력</div>

         <table border="1">
            <c:forEach var="empBoard" items="${categoryList}"></c:forEach>

            <tr>
               <th>카테고리</th>
               <td><input type="hidden" value="${categoryId}"
                  name="categoryId">${categoryName}</td>
            </tr>
            <tr>
               <th>작성자</th>
               <td>${sessionScope.userId}<!--게시글 등록에서 get 할때 보기 위해  --> <input
                  type="hidden" name="userId" value="${userId}"> <!-- post할때 컨트롤러에서 가져오기 위해 -->
               </td>
            </tr>
            <tr>
               <th>제목</th>
               <td><input type="text" style="height: 30px; width: 1088px;"
                  name="empBoardTitle" required></td>
            </tr>
            <tr>
               <th>내용</th>
               <td><input type="text" style="height: 300px; width: 1088px;"
                  name="empBoardContent" required></td>
            </tr>
            <tr>
               <th>첨부파일</th>
               <td><input type="file" name="empFile"></td>
            </tr>
         </table>
         <div align="center" class="click">
            <input type="submit" class="click_button_btn" value="저 장"> <input
               type="reset" class="click_button_btn" value="취 소">
         </div>

      </form>
   </div>

   <%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>