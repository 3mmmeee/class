<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="i18n/user" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취업준비생 상세 게시글</title>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script>

//empBoard delete jqery
$(function() {
 $("a#delete").click(function(event) {
    if(confirm("게시글을 삭제하시겠습니까??")) {
       console.log("게시글 삭제");
       return true;
    } else {
       console.log("삭제 취소");
         return false;
     }
 });
});


//댓글 delete jquery
/* $(function() {
    $("#replydelete").click(function(event) {
       
    });
 }); */
 
 function deleteReply(param){
      let object = $(param);
      
      console.log(object.parent().html());
      if(confirm("댓글을 삭제하시겠습니까??")) {
         console.log("댓글 삭제");
         object.parent().parent().find("#replyDeleteForm").submit();
         
         return true;
      } else {
         console.log("삭제 취소");
           return false;
       }
 }
</script>
<!-- jhBoard -->
</head>
<link rel="stylesheet" type="text/css"
   href="/INeedJob/css/common/default.css">
<link rel="stylesheet" href='/INeedJob/css/jhboard/jhBoardView.css' />
<body class="jhBoardView">
<%@ include file="/WEB-INF/views/header.jsp"%>
   <div class="wrapper">
      <div align="center">
         <img class="ad_img" src="/INeedJob/image/ad.png" />
      </div>
      <div class="hr-sect">취업준비생 게시판</div>
      <table>
         <colgroup>
            <col width="15%">
            <col width="35%">
            <col width="15%">
            <col width="*">
         </colgroup>

         <tbody>
            <tr>
               <th>제목</th>
               <td>${jhBoard.jhBoardTitle}</td>
               <th>조회수</th>
               <td>${jhBoard.jhReadCount}</td>
            </tr>
            <tr>
               <th>작성자</th>
               <td>${jhBoard.userId}</td>
               <th>작성시간</th>
               <td>${jhBoard.jhInsertDate}</td>
            </tr>
            <tr>
               <th>내용</th>
               <td colspan="3" style="padding: 30px; font-size: 23px;">${jhBoard.jhBoardContent}</td>
            </tr>
            <c:if test="${!empty jhBoard.jhFileName}">
               <tr>
                  <th><fmt:message key="FILE" /></th>

                  <td colspan=4><c:set var="len"
                        value="${fn:length(jhBoard.jhFileName)}" /> <c:set
                        var="filetype"
                        value="${fn:toUpperCase(fn:substring(jhBoard.jhFileName, len-4, len))}" />
                     <c:if
                        test="${(filetype eq '.JPG') or (filetype eq 'JPEG') or (filetype eq '.PNG') or (filetype eq '.GIF')}">
                        <img src='<c:url value="/jhFile/${jhBoard.jhFileId}"/>'>
                     </c:if> <a href='<c:url value="/jhFile/${jhBoard.jhFileId}"/>'>${jhBoard.jhFileName}(<fmt:formatNumber>${jhBoard.jhFileSize}</fmt:formatNumber>byte)
                  </a></td>
               </tr>
            </c:if>
      </table>

      <div align="center" class="click">
         <a href='<c:url value="/jhBoard/cat/${page}"/>'>
            <button type="button" class="click_button_btn">
               <fmt:message key="LIST" />
            </button>
         </a> <a href='<c:url value="/jhBoard/update/${categoryId}/${jhId}"/>'>
            <button type="button" class="click_button_btn">
               <fmt:message key="UPDATE" />
            </button>
         </a> <a id="delete"
            href='<c:url value="/jhBoard/delete/${categoryId}/${jhId}"/>'>
            <button type="button" class="click_button_btn">
               <fmt:message key="DELETE" />
            </button>
         </a>
      </div>

      <!-- 댓글 입력-->
      <form action="/INeedJob/reply/jhdetails" method="post">
         <div class="hr-sect">댓글 작성</div>
         <table border="1">
            <tr>
               <th>작성자</th>
               <td>${sessionScope.userId}<!-- 로그인이 되어있는 동안 실행되게 --> <input
                  type="hidden" name="userId" value="${sessionScope.userId}">
               </td>
            </tr>
            <tr>
               <th>내용</th>
               <td><input class="replyInsert" type="text" name="replyContent" required></td>
            </tr>
         </table>
         <input type="hidden" name="categoryId" value="${categoryId}">

         <input type="hidden" name="jhId" value="${jhId}"> 
      
         <div align="center" class="click_reply">
         <input type="submit" class="click_button_btn" value="저 장">
         <input type="reset" class="click_button_btn" value="취 소"></div>
      </form>

      <div class="hr-sect">댓글</div>
      <table border="1">
      <c:forEach var="reply" items="${replyList}">
         <tr class="row1">
<%--                <th>댓글 번호</th>
               <td>${reply.boardReplyNumber}</td> --%>
               <th style="width: 80px;">작성자</th>
               <td style="width: 720px;">${reply.userId}</td>
               <th style="width: 70px;">작성일</th>
               <td style="width: 1px;" colspan="2">${reply.replyInsertDate}</td>
          </tr>
         
         <tr>
               <th>내용</th>
               <td colspan="3">${reply.replyContent}</td>
               <!-- <th>삭제</th> -->
               <td>
                  <form id="replyDeleteForm"
                     action='<c:url value="/replyvo/jhdelete/${reply.boardReplyNumber}/${reply.userId}/"/>'
                     method="get">
                         <input type="hidden" name="categoryId" value="${categoryId}">
                    	 <input type="hidden" name="jhId" value="${jhId}">
                     <div align="center" class="click_reply">
                     <button type="button" class="click_button_btn" 
                        onclick="deleteReply(this)">
                        <fmt:message key="DELETE" />
                     </button>
                     </div>
                  </form>
               </td>
         </tr>
         
         </c:forEach>
      
      
      
         <%-- <tr>
            <th>댓글번호</th>
            <th>작성자</th>
            <th>작성 날짜</th>
            <th>댓글 내용</th>
            <th>삭제</th>

         </tr>
         <c:forEach var="reply" items="${replyList}">
            <tr>
               <td>${reply.boardReplyNumber}</td>
               <td>${reply.userId}</td>
               <td>${reply.replyInsertDate}</td>
               <td>${reply.replyContent}</td>
               <td>
                  <form id="replyDeleteForm"
                     action='<c:url value="/replyvo/jhdelete/${reply.boardReplyNumber}/${reply.userId}/"/>'
                     method="get">
                     <input type="hidden" name="categoryId" value="${categoryId}">
                     <input type="hidden" name="jhId" value="${jhId}">
                     <div align="center" class="click_reply">
                     <button type="button" class="click_button_btn" 
                        onclick="deleteReply(this)">
                        <fmt:message key="DELETE" />
                     </button></div>
                  </form>
               </td>
            </tr>
         </c:forEach> --%>
      </table>
   </div>
<%@ include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>