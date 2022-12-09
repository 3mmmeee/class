package com.developer.myapp.empboard.model;

public class EmpUploadFile {
   private int empFileId;
   private int empId;
   private String empFileName;
   private long empFileSize;
   private String empFileContent;
   private byte[] empFileData;
   
   public int getEmpFileId() {
      return empFileId;
   }
   public void setEmpFileId(int empFileId) {
      this.empFileId = empFileId;
   }
   public int getEmpId() {
      return empId;
   }
   public void setEmpId(int empId) {
      this.empId = empId;
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
   public byte[] getEmpFileData() {
      return empFileData;
   }
   public void setEmpFileData(byte[] empFileData) {
      this.empFileData = empFileData;
   }
   @Override
   public String toString() {
      return "EmpUploadFile [empFileId=" + empFileId + ", empId=" + empId + ", empFileName=" + empFileName
            + ", empFileSize=" + empFileSize + ", empFileContent=" + empFileContent + "]";
   }
   
   

}