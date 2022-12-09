package com.developer.myapp.user.service;

import java.util.List;

import com.developer.myapp.user.model.User;
import com.developer.myapp.user.model.UserUploadFile;

public interface IUserService {
      
   void insertUser(User user) ;
   void insertUser(User user, UserUploadFile file);
   
   User selectUser(String userId);
   List<User> selectAllUsers();
   void updateUser(User user);
   void updateMypage(User user);
  
   String getUserPw(String userId);
   void deleteUser(User user);
   
   UserUploadFile getFile(int fileId); 	// DB�� �ִ� ���� �������� ���� �뵵 
   Integer selectFileId(String userId); 	// ID���� ���ε��� ���� ã�� �뵵

}