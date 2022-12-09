package com.developer.myapp.reply.service;

import java.util.List;

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.reply.model.ReplyVO;

public interface IReplyService {



//emp댓글 입력
void empInsertReply(ReplyVO reply);
//jh댓글 입력
void jhInsertReply(ReplyVO reply);




//보드에 있는 댓글을 보여주기 위해
List<ReplyVO> empReplyList(int empId);
List<ReplyVO> jhReplyList(int jhId);
   
//emp댓글 삭제
String selectDeleteReply(int boardReplyNumber,String userId);

void deleteReply(int boardReplyNumber,String userId);










}