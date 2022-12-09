package com.developer.myapp.jobhunterboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.myapp.jobhunterboard.dao.IJHBoardRepository;
import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.jobhunterboard.model.JHBoardUploadFile;
import com.developer.myapp.jobhunterboard.service.IJHBoardService;

@Service
public class JHBoardService implements IJHBoardService{

	@Autowired
	IJHBoardRepository jhBoardRepository;
	
	@Transactional
	public void insertJHBoardArticle(JHBoard jhBoard) {
		jhBoardRepository.insertJHBoardArticle(jhBoard);
	}

	@Transactional
	public void insertJHBoardArticle(JHBoard jhId, JHBoardUploadFile jhFile) {
		jhBoardRepository.insertJHBoardArticle(jhId);
		jhFile.setJhId(jhBoardRepository.selectMaxJHBoardArticleNo());
		jhBoardRepository.insertJHBoardFildData(jhFile);
	}

	@Override
	public List<JHBoard> selectJHBoardArticleListByCategory(int categoryId, int page) {
		int start = (page-1)*10+1;
		return jhBoardRepository.selectJHBoardArticleListByCategory(categoryId, start, start+9);
	}

	@Override
	public List<JHBoard> selectJHBoardArticleListByCategory(int categoryId) {
		return jhBoardRepository.selectJHBoardArticleListByCategory(categoryId,0,100);
	}
	
	@Transactional
	public JHBoard selectJHBoardArticle(int jhId, int categoryId) {
		jhBoardRepository.updateJHBoardReadCount(jhId);
		return jhBoardRepository.selectJHBoardArticle(jhId, categoryId);
	}

	@Override
	public JHBoardUploadFile getjhFile(int jhFileId) {
		return jhBoardRepository.getJHBoardFile(jhFileId);
	}

	@Override
	public void updateJHBoardArticle(JHBoard jhBoard) {
		jhBoardRepository.updateJHBoardArticle(jhBoard);
	}

	@Transactional
	public void updateJHBoardArticle(JHBoard jhBoard, JHBoardUploadFile jhFile) {
		jhBoardRepository.updateJHBoardArticle(jhBoard);
		if(jhFile != null && jhFile.getJhFileName() != null && !jhFile.getJhFileName().equals("")) {
			jhFile.setJhId(jhBoard.getJhId());
			if(jhFile.getJhFileId()>0) {
				jhBoardRepository.updateJHBoardFileData(jhFile);
			}else {
				jhBoardRepository.insertJHBoardFildData(jhFile);
			}
		}
	}
	
	@Override
	public JHBoard selectDeleteJHBoardArticle(int jhId) {
		return jhBoardRepository.selectDeleteJHBoardArticle(jhId);
	}

	@Transactional
	public void deleteJHBoardArticle(int jhId) {
			jhBoardRepository.deleteJHBoardReply(jhId); //���λ����� ��� �ڵ� ����
			jhBoardRepository.deleteJHBoardFileData(jhId); //���λ����� ���ϻ���
			jhBoardRepository.deleteJHBoardArticleByjhId(jhId); // ���α� ����
	}

	@Override
	public int selectTotalJHBoardArticleCount() {
		return jhBoardRepository.selectTotalJHBoardArticleCount();
	}

	@Override
	public int selectTotalJHBoardArticleCountByCategoryId(int categoryId) {
		return jhBoardRepository.selectTotalJHBoardArticleCountByCategoryId(categoryId);
	}

	@Override
	public List<JHBoard> searchJHBoardListByContentKeyword(String keyword, int page) {
		int start = (page-1)*10+1;
		return jhBoardRepository.searchJHBoardListByContentKeyword("%" + keyword + "%", start, start+9);
	}

	@Override
	public int selectTotalJHBoardArticleCountByKeyword(String keyword) {
		return jhBoardRepository.selectTotalArticleCountByKeyword("%" + keyword + "%");
	}

	@Override
	public int test() {
		
		return jhBoardRepository.test();
	}

	

}
