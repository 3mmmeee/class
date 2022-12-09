package com.developer.myapp.empboard.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.developer.myapp.category.model.BoardCategory;

public class EmpBoard {
   private int empId;
   private String categoryId;
   private String userId;
   private String empBoardTitle;
   private String empBoardContent;
   private Date empInsertDate;
   private int empReadCount;
   
   private int boardReplyNumber;
   private int boardReplyStep;
   private Timestamp replyInsertDate;   
   private int seq;
   private int page;
   
   private BoardCategory category;
   private int empFileId;
   private String empFileName;
   private long empFileSize;
   private String empFileContent;
   private MultipartFile empFile;
   
   public int getEmpId() {
      return empId;
   }
   public void setEmpId(int empId) {
      this.empId = empId;
   }
   public String getCategoryId() {
      return categoryId;
   }
   public void setCategoryId(String categoryId) {
      this.categoryId = categoryId;
   }
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public String getEmpBoardTitle() {
      return empBoardTitle;
   }
   public void setEmpBoardTitle(String empBoardTitle) {
      this.empBoardTitle = empBoardTitle;
   }
   public String getEmpBoardContent() {
      return empBoardContent;
   }
   public void setEmpBoardContent(String empBoardContent) {
      this.empBoardContent = empBoardContent;
   }
   public Date getEmpInsertDate() {
      return empInsertDate;
   }
   public void setEmpInsertDate(Date empInsertDate) {
      this.empInsertDate = empInsertDate;
   }
   public int getEmpReadCount() {
      return empReadCount;
   }
   public void setEmpReadCount(int empReadCount) {
      this.empReadCount = empReadCount;
   }
   public int getBoardReplyNumber() {
      return boardReplyNumber;
   }
   public void setBoardReplyNumber(int boardReplyNumber) {
      this.boardReplyNumber = boardReplyNumber;
   }
   public int getBoardReplyStep() {
      return boardReplyStep;
   }
   public void setBoardReplyStep(int boardReplyStep) {
      this.boardReplyStep = boardReplyStep;
   }
   public Timestamp getReplyInsertDate() {
      return replyInsertDate;
   }
   public void setReplyInsertDate(Timestamp replyInsertDate) {
      this.replyInsertDate = replyInsertDate;
   }
   public int getSeq() {
      return seq;
   }
   public void setSeq(int seq) {
      this.seq = seq;
   }
   public int getPage() {
      return page;
   }
   public void setPage(int page) {
      this.page = page;
   }
   public BoardCategory getCategory() {
      return category;
   }
   public void setCategory(BoardCategory category) {
      this.category = category;
   }
   public int getEmpFileId() {
      return empFileId;
   }
   public void setEmpFileId(int empFileId) {
      this.empFileId = empFileId;
   }
   public String getEmpFileName() {
      return empFileName;
   }
   public void setEmpFileName(String empFileName) {
      this.empFileName = empFileName;
   }
   public long getEmpFileSize() {
      return empFileSize;
   }
   public void setEmpFileSize(long empFileSize) {
      this.empFileSize = empFileSize;
   }
   public String getEmpFileContent() {
      return empFileContent;
   }
   public void setEmpFileContent(String empFileContent) {
      this.empFileContent = empFileContent;
   }
   public MultipartFile getEmpFile() {
      return empFile;
   }
   public void setEmpFile(MultipartFile empFile) {
      this.empFile = empFile;
   }
   @Override
   public String toString() {
      return "EmpBoard [empId=" + empId + ", categoryId=" + categoryId + ", userId=" + userId + ", empBoardTitle="
            + empBoardTitle + ", empBoardContent=" + empBoardContent + ", empInsertDate=" + empInsertDate
            + ", empReadCount=" + empReadCount + ", boardReplyNumber=" + boardReplyNumber + ", boardReplyStep="
            + boardReplyStep + ", replyInsertDate=" + replyInsertDate + ", seq=" + seq + ", page=" + page
            + ", category=" + category + ", empFileId=" + empFileId + ", empFileName=" + empFileName
            + ", empFileSize=" + empFileSize + ", empFileContent=" + empFileContent + "]";
   }
   
}