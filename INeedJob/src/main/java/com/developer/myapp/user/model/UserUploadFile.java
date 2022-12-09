package com.developer.myapp.user.model;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class UserUploadFile {
   private int userFileId;
   private String userId;
   private String userFileName;
   private long userFileSize;
   private String fileContentType;
   private byte[] userFileData;
   private MultipartFile file;
   
public int getUserFileId() {
	return userFileId;
}
public void setUserFileId(int userFileId) {
	this.userFileId = userFileId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
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
	return "UserUploadFile [userFileId=" + userFileId + ", userId=" + userId + ", userFileName=" + userFileName
			+ ", userFileSize=" + userFileSize + ", fileContentType=" + fileContentType + ", userFileData="
			+ Arrays.toString(userFileData) + ", file=" + file + "]";
}

   
}