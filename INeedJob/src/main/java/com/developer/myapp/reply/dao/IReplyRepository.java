package com.developer.myapp.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.developer.myapp.reply.model.ReplyVO;



public interface IReplyRepository {
   int selectMaxBoardReplyNumber(); 
   
   //댓글 등록
   void insertReply(ReplyVO reply);
   
   
   //댓글 리스트
   List<ReplyVO> empReplyList(int empId);
   List<ReplyVO> jhReplyList(int jhId);

   
   ReplyVO selectReply(int empId); 
   
   //댓글 삭제
   String selectDeleteReply(@Param("boardReplyNumber") int boardReplyNumber, @Param("userId") String userId);
   void deleteReplyByReplyId(@Param("boardReplyNumber") int boardReplyNumber, @Param("userId") String userId);




   

}