package com.developer.myapp.jobhunterboard.service;

import java.util.List;

import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.jobhunterboard.model.JHBoardUploadFile;

public interface IJHBoardService {
	int test();
	
	void insertJHBoardArticle(JHBoard jhId);
	void insertJHBoardArticle(JHBoard jhId, JHBoardUploadFile jhFile);
	
	List<JHBoard> selectJHBoardArticleListByCategory(int categoryId, int page); 
	List<JHBoard> selectJHBoardArticleListByCategory(int categoryId);

	JHBoard selectJHBoardArticle(int jhId, int categoryId);
	
	JHBoardUploadFile getjhFile(int jhFileId);
	
//	void replyJHBoardArticle(JHBoard jhBoard);
//	void replyJHBoardArticle(JHBoard jhBoard, JHBoardUploadFile jhFile);
	
//	String getPassword(int jhId);
	
	void updateJHBoardArticle(JHBoard jhBoard);
	void updateJHBoardArticle(JHBoard jhBoard, JHBoardUploadFile jhFile);
	
	JHBoard selectDeleteJHBoardArticle(int jhId);
	void deleteJHBoardArticle(int jhId); // int replyNumber ����
	
	int selectTotalJHBoardArticleCount();
	int selectTotalJHBoardArticleCountByCategoryId(int categoryId);
	
	List<JHBoard> searchJHBoardListByContentKeyword(String keyword, int page);
	int selectTotalJHBoardArticleCountByKeyword(String keyword);


}
