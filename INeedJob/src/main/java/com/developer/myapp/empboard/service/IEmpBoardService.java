package com.developer.myapp.empboard.service;

import java.util.List;

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.empboard.model.EmpUploadFile;

public interface IEmpBoardService {
	void insertEmpBoardArticle(EmpBoard empId);
	void insertEmpBoardArticle(EmpBoard empId, EmpUploadFile file);

	List<EmpBoard> selectEmpBoardArticleListByCategory(int categoryId, int page);
	List<EmpBoard> selectEmpBoardArticleListByCategory(int categoryId);

	EmpBoard selectEmpBoardArticle(int empId, int categoryId);

	void updateEmpBoardArticle(EmpBoard empBoard);
	void updateEmpBoardArticle(EmpBoard empBoard, EmpUploadFile file);

	EmpBoard selectEmpBoardDeleteArticle(int empId);
	void deleteEmpBoardArticle(int empId);

	int selectEmpBoardTotalArticleCount();
	int selectEmpBoardTotalArticleCountByCategoryId(int categoryId);

	List<EmpBoard> searchEmpBoardListByContentKeyword(String keyword, int page);
	int selectEmpBoardTotalArticleCountByKeyword(String keyword);
	EmpUploadFile getEmpFile(int empFileId);



}
