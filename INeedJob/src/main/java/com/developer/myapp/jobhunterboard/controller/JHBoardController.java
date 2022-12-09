package com.developer.myapp.jobhunterboard.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.developer.myapp.category.service.IBoardCategoryService;
import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.jobhunterboard.model.JHBoardUploadFile;
import com.developer.myapp.jobhunterboard.service.IJHBoardService;
import com.developer.myapp.reply.model.ReplyVO;
import com.developer.myapp.reply.service.IReplyService;

@Controller
public class JHBoardController {
	static final Logger logger = LoggerFactory.getLogger(JHBoardController.class);
	
	@Autowired
	IJHBoardService jhBoardService;
	
	@Autowired
	IBoardCategoryService boardCategoryService;
	
	@Autowired
	IReplyService replyService;

	
	@RequestMapping("/jhBoard/cat/{categoryId}/{page}")
	public String getJHBoardListByCategory(@PathVariable int categoryId, @PathVariable int  page, 
			HttpSession session, Model model) {
		session.setAttribute("page", page);
		model.addAttribute("categoryId", categoryId);
		

		String categoryName = "";
		if(categoryId==5) {
			categoryName = "취준생활";
		}else if(categoryId==6) {
			categoryName = "스펙 & 지식";
		}else if(categoryId==7) {
			categoryName = "스터디";
		}
		model.addAttribute("categoryName",categoryName);
		
		
		List<JHBoard> jhBoardList = jhBoardService.selectJHBoardArticleListByCategory(categoryId, page);
		model.addAttribute("jhBoardList", jhBoardList);
		logger.info("cat/:"+jhBoardList);
		//paging start
		int bbsCount = jhBoardService.selectTotalJHBoardArticleCountByCategoryId(categoryId);
		int totalPage = 0;
		if(bbsCount > 0) { totalPage=(int)Math.ceil(bbsCount/10.0);}
		model.addAttribute("totalPageCount", totalPage);
		model.addAttribute("page", page);
		return "jhboard/jhBoardList";
	}
		
	@RequestMapping("/jhBoard/cat/{categoryId}")
	public String getJHBoardListByCategory(@PathVariable int categoryId, HttpSession session, Model model) {
		return getJHBoardListByCategory(categoryId, 1, session, model);
	}
	

	
	@RequestMapping("/jhBoard/details/{categoryId}/{jhId}/{page}")
	public String getJHBoardDetails(@PathVariable int categoryId, @PathVariable int jhId, @PathVariable int page, Model model, HttpSession session) {
		String categoryName = boardCategoryService.getCategoryName(categoryId);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryName", categoryName);
		session.setAttribute("page", page);
		//댓글 리스트
		model.addAttribute("boardReplyNumber",jhId);
		List<ReplyVO> replyList = replyService.jhReplyList(jhId);
		logger.info("list/replyList:"+replyList);
		model.addAttribute("replyList",replyList);
		
		model.addAttribute("page", page);
		JHBoard jhBoardDetails = jhBoardService.selectJHBoardArticle(jhId, categoryId);
		model.addAttribute("jhBoard", jhBoardDetails);
		//logger.info("getJHBoardDetails" + jhBoardDetails.toString());
		return "jhboard/jhBoardView";
	}
	
	@RequestMapping("/jhBoard/details/{jhId}")
	public String getJHBoardDetails(@PathVariable int categoryId, @PathVariable int jhId, Model model, HttpSession session) {
		return getJHBoardDetails(categoryId ,jhId, 1, model,session );
	}
	
	@RequestMapping(value="/jhBoard/insert/{categoryId}", method=RequestMethod.GET)
	public String insertJHBoardArticle(@PathVariable int categoryId, Model model,HttpSession session) {		
		String categoryName = boardCategoryService.getCategoryName(categoryId);
		logger.info("categoryName:"+categoryName);
		logger.info("categoryId:"+categoryId);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryName", categoryName);
	    model.addAttribute("userId", session.getAttribute("userId")); //로그인 연결했을때 확인
		return "jhboard/jhBoardInsert";
	}
	
	@RequestMapping(value="/jhBoard/insert", method=RequestMethod.POST)
	public String insertJHBoardArticle(JHBoard jhBoard, BindingResult result, RedirectAttributes redirectAttributes) {
//		System.out.print(jhBoard.toString());
		logger.info("/jhBoard/insert : " + jhBoard.toString());
		MultipartFile mfile = jhBoard.getFile(); 
		
		try {
			jhBoard.setJhBoardTitle(Jsoup.clean(jhBoard.getJhBoardTitle(), Whitelist.basic()));
			jhBoard.setJhBoardContent(Jsoup.clean(jhBoard.getJhBoardContent(), Whitelist.basic()));
			if(mfile!=null && !mfile.isEmpty()) {
				logger.info("/jhBoard/insert : " + mfile.getOriginalFilename());
				JHBoardUploadFile jhFile = new JHBoardUploadFile();
				jhFile.setJhFileName(mfile.getOriginalFilename());
				jhFile.setJhFileSize(mfile.getSize());
				jhFile.setJhFileContent(mfile.getContentType());
				jhFile.setJhFileData(mfile.getBytes());
				logger.info("/jhBoard/insert : " + jhFile.toString());
				
				jhBoardService.insertJHBoardArticle(jhBoard, jhFile);
			}else {
				jhBoardService.insertJHBoardArticle(jhBoard);
			}
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/jhBoard/cat/"+jhBoard.getCategoryId();
	}
	
	@RequestMapping("/jhFile/{jhFileId}")
	public ResponseEntity<byte[]> getjhFile(@PathVariable int jhFileId){
		JHBoardUploadFile jhfile = jhBoardService.getjhFile(jhFileId);
//		System.out.println("����"+jhfile);
		logger.info("getjhFile " + jhfile.toString());
		final HttpHeaders headers = new HttpHeaders();
		String[] mtypes = jhfile.getJhFileContent().split("/");
		headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
		headers.setContentLength(jhfile.getJhFileSize());
		headers.setContentDispositionFormData("attachment", jhfile.getJhFileName(), Charset.forName("UTF-8"));
		return new ResponseEntity<byte[]>(jhfile.getJhFileData(), headers, HttpStatus.OK);
	}
	
	@RequestMapping(value="/jhBoard/update/{categoryId}/{jhId}", method=RequestMethod.GET)
	public String updateJHBoardArticle(@PathVariable int categoryId, @PathVariable int jhId, Model model) {
//		List<BoardCategory> categoryList = boardCategoryService.selectAllCategory();
//		model.addAttribute("categoryList", categoryList);
		
		String categoryName = boardCategoryService.getCategoryName(categoryId);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryName", categoryName);
		
		JHBoard jhBoard = jhBoardService.selectJHBoardArticle(jhId, categoryId);
		logger.info("update"+jhBoard);
//		model.addAttribute("categoryId", jhBoard.getCategoryId());
		model.addAttribute("jhBoard", jhBoard);
		return "jhboard/jhBoardUpdate";
	}
	
	@RequestMapping(value="/jhBoard/update", method=RequestMethod.POST)
	public String updateJHBoardArticle(JHBoard jhBoard, BindingResult result, HttpSession session,
			RedirectAttributes redirectAttributes) {
		logger.info("/jhBoard/update " + jhBoard.toString());
		try {
			jhBoard.setJhBoardTitle(Jsoup.clean(jhBoard.getJhBoardTitle(), Whitelist.basic()));
			jhBoard.setJhBoardContent(Jsoup.clean(jhBoard.getJhBoardContent(), Whitelist.basic()));
			MultipartFile mfile = jhBoard.getFile();
			if(mfile!=null && !mfile.isEmpty()) {
				logger.info("/jhBoard/update : " + mfile.getOriginalFilename());
				JHBoardUploadFile jhFile = new JHBoardUploadFile();
				jhFile.setJhFileId(jhBoard.getJhFileId());
				jhFile.setJhFileName(mfile.getOriginalFilename());
				jhFile.setJhFileSize(mfile.getSize());
				jhFile.setJhFileContent(mfile.getContentType());
				jhFile.setJhFileData(mfile.getBytes());
				logger.info("/jhBoard/update : " + jhFile.toString());
				jhBoardService.updateJHBoardArticle(jhBoard, jhFile);
			}else {
				jhBoardService.updateJHBoardArticle(jhBoard);
			}
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttributes.addFlashAttribute("message", e.getMessage());
		}
		return "redirect:/jhBoard/details/"+jhBoard.getCategoryId()+"/"+jhBoard.getJhId()+"/1";
	
	}
	
//	@RequestMapping(value="/jhBoard/delete/{categoryId}/{jhId}", method=RequestMethod.GET)
//	public String deleteJHBoardArticle(@PathVariable int jhId, Model model) {
//		JHBoard jhBoard = jhBoardService.selectDeleteJHBoardArticle(jhId);
//		model.addAttribute("categoryId", jhBoard.getCategoryId());
//		model.addAttribute("jhId", jhId);
//		return "jhboard/delete";
//	}
	   //�Խñ� ���� 
	   @RequestMapping(value="/jhBoard/delete/{categoryId}/{jhId}", method=RequestMethod.GET)
	   public String deleteJHBoardArticle(@PathVariable int categoryId,@PathVariable int jhId, JHBoard jhBoard, BindingResult result, HttpSession session, Model model) {
	      logger.info("/jhBoard/delete : " +jhBoard.toString());
	      jhBoardService.deleteJHBoardArticle(jhId);
	      return "redirect:/jhBoard/cat/" + jhBoard.getCategoryId() + "/" + (Integer)session.getAttribute("page");
	      }

	@RequestMapping("/jhBoard/search/{page}")
	public String search(@RequestParam(required=false, defaultValue="") String keyword, @PathVariable int page, 
	HttpSession session, Model model) {
		try {
			List<JHBoard> jhBoardList = jhBoardService.searchJHBoardListByContentKeyword(keyword, page);
			model.addAttribute("jhBoardList", jhBoardList);
			
			//paging start
			int bbsCount=jhBoardService.selectTotalJHBoardArticleCountByKeyword(keyword);
			int totalPage=0;
			System.out.println(bbsCount);
			if(bbsCount>0) {
				totalPage=(int)Math.ceil(bbsCount/10.0);
			}
			model.addAttribute("totalPageCount", totalPage);
			model.addAttribute("page", page);
			model.addAttribute("keyword", keyword);
			logger.info(totalPage + ":" + page + ":" + keyword);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "jhboard/jhBoardSearch";
	}
}
