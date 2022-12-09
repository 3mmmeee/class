package com.developer.myapp.empboard.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.myapp.empboard.dao.IEmpBoardRepository;
import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.empboard.model.EmpUploadFile;
import com.developer.myapp.empboard.service.IEmpBoardService; 

@Service
public class EmpBoardService implements IEmpBoardService {
	
	@Autowired
	IEmpBoardRepository empBoardRepository;
	
	//게시글 입력
	@Transactional
	public void insertEmpBoardArticle(EmpBoard empId) {
		empBoardRepository.insertEmpBoardArticle(empId);
	}
	//첨부 파일 있는 게시글 입력
	@Override
	public void insertEmpBoardArticle(EmpBoard empId, EmpUploadFile file) {
		empBoardRepository.insertEmpBoardArticle(empId);
		file.setEmpId(empBoardRepository.selectMaxEmpBoardArticleNo());
		empBoardRepository.insertEmpBoardFileData(file);
		}

	//카테고리별 게시글 목록
	@Override
	public List<EmpBoard> selectEmpBoardArticleListByCategory(int categoryId, int page) {
		int start = (page -1) * 11;
		return empBoardRepository.selectEmpBoardArticleListByCategory(categoryId, start, start+9);
	}
	//카테고리별 게시글 목록 - 페이지 없을때
	@Override
	public List<EmpBoard> selectEmpBoardArticleListByCategory(int categoryId) {
		return empBoardRepository.selectEmpBoardArticleListByCategory(categoryId, 0, 100);
	}
	//게시글 상세 조회
	@Transactional
	public EmpBoard selectEmpBoardArticle(int empId, int categoryId) {
		empBoardRepository.updateEmpBoardReadCount(empId);
//		System.out.println(empBoardRepository.);
		return empBoardRepository.selectEmpBoardArticle(empId, categoryId);
	}
	//게시글 수정
	@Override
	public void updateEmpBoardArticle(EmpBoard empBoard) {
		empBoardRepository.updateEmpBoardArticle(empBoard);
	}
	//게시글 파일 수정
	@Transactional
	public void updateEmpBoardArticle(EmpBoard empBoard, EmpUploadFile file) {
		empBoardRepository.updateEmpBoardArticle(empBoard);
		if(file != null && file.getEmpFileName() != null&&
				!file.getEmpFileName().equals("")) {
			file.setEmpId(empBoard.getEmpId());
			if(file.getEmpFileId()>0) {
				empBoardRepository.updateEmpBoardFileData(file);
			}else {
				empBoardRepository.insertEmpBoardFileData(file);
			}
		}

	}
	//삭제할 게시글 정보 가져옴
	@Override
	public EmpBoard selectEmpBoardDeleteArticle(int empId) {
		return empBoardRepository.selectEmpBoardDeleteArticle(empId);
	}
	//게시글 삭제
	@Transactional
	public void deleteEmpBoardArticle(int empId) {
		empBoardRepository.deleteEmpBoardReply(empId);
		empBoardRepository.deleteEmpBoardFileData(empId);
		empBoardRepository.deleteEmpBoardArticleByBoardId(empId);
	}
	 //게시글 총 갯수
	@Override
	public int selectEmpBoardTotalArticleCount() {
		return empBoardRepository.selectEmpBoardTotalArticleCount();
	}
	//카테고리 안에 있는 게시글 갯수
	@Override
	public int selectEmpBoardTotalArticleCountByCategoryId(int categoryId) {
		return empBoardRepository.selectEmpBoardTotalArticleCountByCategoryId(categoryId);
	}
	//키워드 별 게시글 검색
	@Override
	public List<EmpBoard> searchEmpBoardListByContentKeyword(String keyword, int page) {
		int start = (page -1) * 11;
		return empBoardRepository.searchEmpBoardListByContentKeyword("%"+keyword+"%", start, start+9);
	}
	//검색 키워드 별 게시글 수
	@Override
	public int selectEmpBoardTotalArticleCountByKeyword(String keyword) {		
		return empBoardRepository.selectEmpBoardTotalArticleCountByKeyword("%"+keyword+"%");
	}
	@Override
	public EmpUploadFile getEmpFile(int empFileId) {
		return empBoardRepository.getEmpFile(empFileId);
	}

}
