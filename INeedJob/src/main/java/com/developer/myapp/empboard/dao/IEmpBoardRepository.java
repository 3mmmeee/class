package com.developer.myapp.empboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.empboard.model.EmpUploadFile;

public interface IEmpBoardRepository {
   //게시글 최대번호
   int selectMaxEmpBoardArticleNo();
   //파일ID 최대번호
   int selectMaxEmpBoardFileId();
   
   //게시글 입력
   void insertEmpBoardArticle(EmpBoard board);
   //파일 첨부
   void insertEmpBoardFileData(EmpUploadFile empFile);
   //게시글 목록 조회
   List<EmpBoard> selectEmpBoardArticleListByCategory(@Param("categoryId") int categoryId, 
            @Param("start") int start, @Param("end") int end);
   //게시글 상세 조회
   EmpBoard selectEmpBoardArticle(@Param("empId") int empId, @Param("categoryId") int categoryId);
   //게시글 사진 상세조회
   EmpUploadFile getEmpFile(int empFileId);
   //조회 수 업데이트
   void updateEmpBoardReadCount(int boardId);
   //게시글 수정
   void updateEmpBoardArticle(EmpBoard board);
   //파일 수정
   void updateEmpBoardFileData(EmpUploadFile empFile);
   
   //삭제할 게시글 정보 가져옴
   EmpBoard selectEmpBoardDeleteArticle(int boardId);
   //파일 삭제
   void deleteEmpBoardFileData(int boardId);
   //게시글 안에 댓글 삭제
   void deleteEmpBoardReply(int boardId);
   //게시글 삭제
   void deleteEmpBoardArticleByBoardId(int boardId);
   
   //게시글 총 수
   int selectEmpBoardTotalArticleCount();
   //카테고리 안에 있는 게시글 개수
   int selectEmpBoardTotalArticleCountByCategoryId(int category);
   
   //키워드 별 게시글 수
   int selectEmpBoardTotalArticleCountByKeyword(String keyword);
   //키워드 별 게시글 검색
   List<EmpBoard> searchEmpBoardListByContentKeyword(@Param("keyword") String keyword, @Param("start") int start,
         @Param("end") int end);
}