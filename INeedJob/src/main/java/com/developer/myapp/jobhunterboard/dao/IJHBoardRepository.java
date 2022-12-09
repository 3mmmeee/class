package com.developer.myapp.jobhunterboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.jobhunterboard.model.JHBoardUploadFile;


// BoardService���� ���
@Repository
public interface IJHBoardRepository {
	int test();
	int selectMaxJHBoardArticleNo();
	int selectMaxJHBoardFileId();
	
	void insertJHBoardArticle(JHBoard jhBoard);
	void insertJHBoardFildData(JHBoardUploadFile jhFile);
	
	List<JHBoard> selectJHBoardArticleListByCategory(@Param("categoryId") int categoryId,
			@Param("start") int start, @Param("end")int end);
	
	JHBoard selectJHBoardArticle(@Param("jhId") int jhId, @Param("categoryId") int categoryId);
	JHBoardUploadFile getJHBoardFile(int jhFileId);
	
	void updateJHBoardReadCount(int jhId);
//	void updateReplyNumber(@Param("masterId") int masterId,
//			@Param("boardReplyNumber") int boardReplyNumber);
//	void replyArticle(jhBoard jhId);
	
//	String getPassword(int jhId);
	void updateJHBoardArticle(JHBoard jhBoard);
	void updateJHBoardFileData(JHBoardUploadFile jhFile);

	void deleteJHBoardFileData(int jhId); //���α� ���� ����
	void deleteJHBoardReply(int jhId); //���α� �������� �� ��� ����
//	void deleteReplyFileData(int jhId); //��۸� ����
	JHBoard selectDeleteJHBoardArticle(int jhId); 
	void deleteJHBoardArticleByjhId(int jhId); //���α� ����
	
	int selectTotalJHBoardArticleCount();
	int selectTotalJHBoardArticleCountByCategoryId(int categoryId);
	int selectTotalArticleCountByKeyword(String keyword);
	List<JHBoard> searchJHBoardListByContentKeyword(@Param("keyword") String keyword,
			@Param("start") int start, @Param("end") int end);
}
