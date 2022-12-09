package com.developer.myapp.reply.model;

import java.util.Date;

public class ReplyVO {
   private int boardReplyNumber;
   private int empId;
   private int jhId;
   private String userId;
   private Date replyInsertDate;
   private String replyContent;
   private int boardReplyStep;
   
   
   
   
   public int getBoardReplyNumber() {
      return boardReplyNumber;
   }
   public void setBoardReplyNumber(int boardReplyNumber) {
      this.boardReplyNumber = boardReplyNumber;
   }
   public int getEmpId() {
      return empId;
   }
   public void setEmpId(int empId) {
      this.empId = empId;
   }
   public int getJhId() {
      return jhId;
   }
   public void setJhId(int jhId) {
      this.jhId = jhId;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public Date getReplyInsertDate() {
      return replyInsertDate;
   }
   public void setReplyInsertDate(Date replyInsertDate) {
      this.replyInsertDate = replyInsertDate;
   }
   public String getReplyContent() {
      return replyContent;
   }
   public void setReplyContent(String replyContent) {
      this.replyContent = replyContent;
   }
   public int getBoardReplyStep() {
      return boardReplyStep;
   }
   public void setBoardReplyStep(int boardReplyStep) {
      this.boardReplyStep = boardReplyStep;
   }
   @Override
   public String toString() {
      return "BoardReply [boardReplyNumber=" + boardReplyNumber + ", empId=" + empId + ", jhId=" + jhId + ", userId="
            + userId + ", replyInsertDate=" + replyInsertDate + ", replyContent=" + replyContent
            + ", boardReplyStep=" + boardReplyStep + "]";
   }
   
   
   
   

}