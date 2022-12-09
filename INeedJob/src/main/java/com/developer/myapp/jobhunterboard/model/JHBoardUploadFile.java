package com.developer.myapp.jobhunterboard.model;

public class JHBoardUploadFile {
	   private int jhFileId; 
	   private int jhId;
	   private String jhFileName;
	   private long jhFileSize;
	   private String jhFileContent;
	   private byte[] jhFileData;
	   public int getJhFileId() {
	      return jhFileId;
	   }
	   public void setJhFileId(int jhFileId) {
	      this.jhFileId = jhFileId;
	   }
	   public int getJhId() {
	      return jhId;
	   }
	   public void setJhId(int jhId) {
	      this.jhId = jhId;
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
	   public byte[] getJhFileData() {
	      return jhFileData;
	   }
	   public void setJhFileData(byte[] jhFileData) {
	      this.jhFileData = jhFileData;
	   }
	   @Override
	   public String toString() {
	      return "JobHunterUploadFile [jhFileId=" + jhFileId + ", jhId=" + jhId + ", jhFileName=" + jhFileName
	            + ", jhFileSize=" + jhFileSize + ", jhFileContent=" + jhFileContent + "]";
	   }

}
