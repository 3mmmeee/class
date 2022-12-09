package com.developer.myapp.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.reply.dao.IReplyRepository;
import com.developer.myapp.reply.model.ReplyVO;

@Service
public class ReplyService implements IReplyService {

   
   @Autowired
   IReplyRepository replyRepository;
   
   @Transactional
   
   //댓글 달기
   @Override
   public void empInsertReply(ReplyVO reply) {
      replyRepository.insertReply(reply);
   }

   
   //댓글 리스트
   @Override
   public List<ReplyVO> empReplyList(int boardReplyNumber) {
      
      return replyRepository.empReplyList(boardReplyNumber);
   }
   

   //댓글 삭제
   @Override
   public String selectDeleteReply(int boardReplyNumber, String userId) {
      
      return replyRepository.selectDeleteReply(boardReplyNumber, userId);
      }

   @Override
   public void deleteReply(int boardReplyNumber,String userId) {
      replyRepository.deleteReplyByReplyId(boardReplyNumber,userId );
   
      
   }


   //jh댓글 등록
@Override
public void jhInsertReply(ReplyVO reply) {
    reply.setBoardReplyNumber(replyRepository.selectMaxBoardReplyNumber()+1);
    System.out.println(reply.toString());
    replyRepository.insertReply(reply);
}



	//jh댓글 리스트
@Override
public List<ReplyVO> jhReplyList(int boardReplyNumber) {
	
	 return replyRepository.jhReplyList(boardReplyNumber);

}


   
}