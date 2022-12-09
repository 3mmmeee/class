package com.developer.myapp.user.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
   private String userId;
   private String userPw;
   private String userName;
   private String userEmail;
   private String userCompany;
   private String userApproval;

   private int userFileId;
   private String userFileName;
   private long userFileSize;
   private String fileContentType;
   private byte[] userFileData;
   private MultipartFile file;
   
   public String getUserId() {
      return userId;
   }
   public void setUserId(String userId) {
      this.userId = userId;
   }
   public String getUserPw() {
      return userPw;
   }
   public void setUserPw(String userPw) {
      this.userPw = userPw;
   }
   public String getUserName() {
      return userName;
   }
   public void setUserName(String userName) {
      this.userName = userName;
   }
   public String getUserEmail() {
      return userEmail;
   }
   public void setUserEmail(String userEmail) {
      this.userEmail = userEmail;
   }
   public String getUserCompany() {
      return userCompany;
   }
   public void setUserCompany(String userCompany) {
      this.userCompany = userCompany;
   }
   public String getUserApproval() {
      return userApproval;
   }
   public void setUserApproval(String userApproval) {
      this.userApproval = userApproval;
   }
public int getUserFileId() {
	return userFileId;
}
public void setUserFileId(int userFileId) {
	this.userFileId = userFileId;
}
public String getUserFileName() {
	return userFileName;
}
public void setUserFileName(String userFileName) {
	this.userFileName = userFileName;
}
public long getUserFileSize() {
	return userFileSize;
}
public void setUserFileSize(long userFileSize) {
	this.userFileSize = userFileSize;
}
public String getFileContentType() {
	return fileContentType;
}
public void setFileContentType(String fileContentType) {
	this.fileContentType = fileContentType;
}
public byte[] getUserFileData() {
	return userFileData;
}
public void setUserFileData(byte[] userFileData) {
	this.userFileData = userFileData;
}
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
@Override
public String toString() {
	return "User [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", userEmail=" + userEmail
			+ ", userCompany=" + userCompany + ", userApproval=" + userApproval + ", userFileId=" + userFileId
			+ ", userFileName=" + userFileName + ", userFileSize=" + userFileSize + ", fileContentType="
			+ fileContentType + "]";
}
   
   
   
}