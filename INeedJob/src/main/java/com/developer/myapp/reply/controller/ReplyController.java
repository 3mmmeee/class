package com.developer.myapp.reply.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.reply.model.ReplyVO;
import com.developer.myapp.reply.service.IReplyService;

@Controller
public class ReplyController {
   static final Logger logger = LoggerFactory.getLogger(ReplyController.class);

   @Autowired
   IReplyService replyService;
   
   


   
   
   
   //emp reply등록.post

   @RequestMapping(value="/reply/details", method=RequestMethod.POST)
   public String BoardReply(int categoryId, ReplyVO reply, BindingResult result, RedirectAttributes redirectAttrs, HttpSession session) {
      logger.info("/reply:"+reply.toString());
      try {
         reply.setReplyContent(Jsoup.clean(reply.getReplyContent(), Whitelist.basic()));
         replyService.empInsertReply(reply);
         System.out.println(reply);
      }catch (Exception e) {
         e.printStackTrace();
         redirectAttrs.addFlashAttribute("message", e.getMessage());
      
      }
      //logger.info("/empBoard/details:"+empBoard.toString());
      System.out.println("redirect:/empBoard/details/"+categoryId +"/"+ reply.getEmpId() +"/1");
      return "redirect:/empBoard/details/"+ categoryId +"/"+ reply.getEmpId() +"/1";
   }
   
   
   
  //Jhreply등록.post
   @RequestMapping(value="/reply/jhdetails", method=RequestMethod.POST)
   public String BoardReply2(int categoryId, ReplyVO reply,JHBoard jhboard, BindingResult result, RedirectAttributes redirectAttrs, HttpSession session) {
      logger.info("/reply:"+reply.toString());
      try {
         reply.setReplyContent(Jsoup.clean(reply.getReplyContent(), Whitelist.basic()));
         replyService.jhInsertReply(reply);

      }catch (Exception e) {
         e.printStackTrace();
         redirectAttrs.addFlashAttribute("message", e.getMessage());
      
      }
      logger.info("/jhBoard/details:"+jhboard.toString());
      System.out.println("redirect:/jhBoard/details/"+categoryId +"/"+reply.getJhId()+"/1");
      return "redirect:/jhBoard/details/"+categoryId+"/"+reply.getJhId()+"/1";
   }
   
   
   
   
   
   
   


   //empreply지우기.GET
   @RequestMapping(value="/replyvo/delete/{boardReplyNumber}/{userId}",method=RequestMethod.GET)
   public String deleteReply(@PathVariable String userId, @PathVariable int boardReplyNumber,Model model,ReplyVO reply,EmpBoard empBoard) {
      replyService.deleteReply(boardReplyNumber,userId);
      logger.info("delete/reply:"+reply.toString());
      return "redirect:/empBoard/details/"+empBoard.getCategoryId() +"/"+empBoard.getEmpId() +"/1";

   }

   
//   
//   //jhReply지우기.get
   @RequestMapping(value="/replyvo/jhdelete/{boardReplyNumber}/{userId}",method=RequestMethod.GET)
   public String deleteReply2(@PathVariable String userId, @PathVariable int boardReplyNumber,Model model,ReplyVO reply,JHBoard jhboard) {
      replyService.deleteReply(boardReplyNumber,userId);
      logger.info("delete/reply:"+reply.toString());
      return "redirect:/jhBoard/details/"+jhboard.getCategoryId() +"/"+jhboard.getJhId() +"/1";

   }
   
   
   





}