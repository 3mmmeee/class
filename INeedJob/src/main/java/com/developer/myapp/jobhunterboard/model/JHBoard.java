package com.developer.myapp.jobhunterboard.model;

import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.web.multipart.MultipartFile;

import com.developer.myapp.category.model.BoardCategory;

public class JHBoard {
	private int jhId;
	private int categoryId;
	private String userId;
	private String jhBoardTitle;
	private String jhBoardContent;
	private Date jhInsertDate;
	private int jhReadCount;
	private Timestamp replyInsertDate;
	private int boardReplyNumber;
	private int boardReplyStep;
	private int seq;
	private int page;
	private BoardCategory category;
	private MultipartFile file;
	
	private int jhFileId;
	private String jhFileName;
	private long jhFileSize;
	private String jhFileContent;
	public int getJhId() {
		return jhId;
	}
	public void setJhId(int jhId) {
		this.jhId = jhId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getJhBoardTitle() {
		return jhBoardTitle;
	}
	public void setJhBoardTitle(String jhBoardTitle) {
		this.jhBoardTitle = jhBoardTitle;
	}
	public String getJhBoardContent() {
		return jhBoardContent;
	}
	public void setJhBoardContent(String jhBoardContent) {
		this.jhBoardContent = jhBoardContent;
	}
	public Date getJhInsertDate() {
		return jhInsertDate;
	}
	public void setJhInsertDate(Date jhInsertDate) {
		this.jhInsertDate = jhInsertDate;
	}
	public int getJhReadCount() {
		return jhReadCount;
	}
	public void setJhReadCount(int jhReadCount) {
		this.jhReadCount = jhReadCount;
	}
	public Timestamp getReplyInsertDate() {
		return replyInsertDate;
	}
	public void setReplyInsertDate(Timestamp replyInsertDate) {
		this.replyInsertDate = replyInsertDate;
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
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public int getJhFileId() {
		return jhFileId;
	}
	public void setJhFileId(int jhFileId) {
		this.jhFileId = jhFileId;
	}
	public String getJhFileName() {
		return jhFileName;
	}
	public void setJhFileName(String jhFileName) {
		this.jhFileName = jhFileName;
	}
	public long getJhFileSize() {
		return jhFileSize;
	}
	public void setJhFileSize(long jhFileSize) {
		this.jhFileSize = jhFileSize;
	}
	public String getJhFileContent() {
		return jhFileContent;
	}
	public void setJhFileContent(String jhFileContent) {
		this.jhFileContent = jhFileContent;
	}
	@Override
	public String toString() {
		return "JHBoard [jhId=" + jhId + ", categoryId=" + categoryId + ", userId=" + userId + ", jhBoardTitle="
				+ jhBoardTitle + ", jhBoardContent=" + jhBoardContent + ", jhInsertDate=" + jhInsertDate
				+ ", jhReadCount=" + jhReadCount + ", replyInsertDate=" + replyInsertDate + ", boardReplyNumber="
				+ boardReplyNumber + ", boardReplyStep=" + boardReplyStep + ", seq=" + seq + ", page=" + page
				+ ", category=" + category + ", file=" + file + ", jhFileId=" + jhFileId + ", jhFileName=" + jhFileName
				+ ", jhFileSize=" + jhFileSize + ", jhFileContent=" + jhFileContent + "]";
	}

}