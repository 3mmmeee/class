package com.developer.myapp.user.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.developer.myapp.user.model.User;
import com.developer.myapp.user.model.UserUploadFile;

@Repository
public interface IUserRepository { // ȸ������ ����� ������ �������̽�
   void insertUser(User user) ;
   User selectUser(String userid);
   List<User> selectAllUsers();
   void updateUser(User user);
   void updateMypage(User user);
   void deleteUser(User user);
   String getUserPw(String userId);
   
   void UserUploadFile(UserUploadFile file);
   void deleteFile(User user); // ȸ�� Ż�� �� ���ε��� ȸ�� ����(FILE) �Բ� ���� 
   
   UserUploadFile getFile(int userFileId);
   Integer selectFileId(String userId); // ID�� ���� ���ε� ��ȸ(userId�� ���� int�� result�� �޴´�) 
}
