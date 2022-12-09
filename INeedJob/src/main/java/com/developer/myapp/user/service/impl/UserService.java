package com.developer.myapp.user.service.impl;

import java.lang.annotation.Target;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.myapp.empboard.dao.IEmpBoardRepository;
import com.developer.myapp.jobhunterboard.dao.IJHBoardRepository;
import com.developer.myapp.reply.dao.IReplyRepository;
import com.developer.myapp.user.dao.IUserRepository;
import com.developer.myapp.user.model.User;
import com.developer.myapp.user.model.UserUploadFile;
import com.developer.myapp.user.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserRepository userDao;

	@Override // �Է�
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	@Transactional
	@Override // �Է�
	public void insertUser(User user, UserUploadFile file) {
		System.out.println(user);
		userDao.insertUser(user);
		userDao.UserUploadFile(file);
	}
	@Override // ��ȸ
	public User selectUser(String userId) {
		return userDao.selectUser(userId);
	}

	@Override // ��ü ��ȸ
	public List<User> selectAllUsers() {
		return userDao.selectAllUsers();
	}

	@Override // ȸ�� ���� ���� 
	public void updateMypage(User user) {
		userDao.updateMypage(user);

	}

	@Override // ������ �������� ȸ�� ���� ����
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Transactional
	public void deleteUser(User user) {
		userDao.deleteFile(user);
		userDao.deleteUser(user);

	}

	@Override
	public String getUserPw(String userId) {
		return userDao.getUserPw(userId);
	}

	@Override // DB�� �ִ� ���� �������� ���� �뵵 
	public UserUploadFile getFile(int fileId) {
		return userDao.getFile(fileId);
	}

	@Override // ���� ��ȣ ã�� �뵵
	public Integer selectFileId(String userId) {
		return userDao.selectFileId(userId);
	}


}
