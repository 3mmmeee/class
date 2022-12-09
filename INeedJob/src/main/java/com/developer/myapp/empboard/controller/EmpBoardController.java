package com.developer.myapp.empboard.controller;

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

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.category.service.IBoardCategoryService;
import com.developer.myapp.empboard.model.EmpUploadFile;
import com.developer.myapp.empboard.service.IEmpBoardService;
import com.developer.myapp.reply.model.ReplyVO;
import com.developer.myapp.reply.service.IReplyService;

@Controller
public class EmpBoardController {
	static final Logger logger=LoggerFactory.getLogger(EmpBoardController.class);

	@Autowired
	IEmpBoardService empBoardService;

	@Autowired
	IBoardCategoryService boardCategoryService;
	
	@Autowired
	IReplyService replyService;

	//게시글 목록
	@RequestMapping("/empBoard/cat/{categoryId}/{page}")
	public String getListByCategory(@PathVariable int categoryId, @PathVariable int page,
			HttpSession session, Model model) {
		session.setAttribute("page", page);
		model.addAttribute("categoryId",categoryId);
		
		String categoryName = "";
		if(categoryId==1) {
			categoryName = "회사생활";
		}else if(categoryId==2) {
			categoryName = "이직 & 커리어";
		}else if(categoryId==3) {
			categoryName = "지식공유";
		}else if(categoryId==4) {
			categoryName = "채용공고";
		}
		model.addAttribute("categoryName",categoryName);
		
		List<EmpBoard> empBoardList =
				empBoardService.selectEmpBoardArticleListByCategory(categoryId, page);
		model.addAttribute("empBoardList", empBoardList);
			
		//paging start
		int bbsCount = empBoardService.selectEmpBoardTotalArticleCountByCategoryId(categoryId);
		int totalPage =0;
		if(bbsCount > 0) {
			totalPage=(int)Math.ceil(bbsCount/10.0);
		}
		model.addAttribute("totalPageCount", totalPage);
		model.addAttribute("page", page);
		return "empboard/empBoardList";
	}

	@RequestMapping("/empBoard/cat/{categoryId}")	
	public String getListByCategory(@PathVariable int categoryId, HttpSession session, 
			Model model) {
		return getListByCategory(categoryId, 1, session, model);
	}

	//게시글 상세 조회
	@RequestMapping("/empBoard/details/{categoryId}/{empId}/{page}")
	public String getEmpBoardDetails( @PathVariable int categoryId, @PathVariable int empId,@PathVariable int page
			,Model model, HttpSession session) {
		String categoryName = boardCategoryService.getCategoryName(categoryId);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryName", categoryName);
		session.setAttribute("page", page);
		//댓글 리스트
		model.addAttribute("boardReplyNumber",empId);
		List<ReplyVO> replyList = replyService.empReplyList(empId);
		logger.info("list/replyList:"+replyList);
		model.addAttribute("replyList",replyList);
		
		model.addAttribute("page", page);
		//empBoardDetails가 NULL이라서 error 로그 수정하세용
		EmpBoard empBoardDetails = empBoardService.selectEmpBoardArticle(empId, categoryId);
		model.addAttribute("empBoard",empBoardDetails);
		//empBoardDetails		logger.info("getEmpBoardDetails "+ empBoardDetails.toString());
		System.out.println(empBoardDetails);
		return "empboard/empBoardDetails";
	}
	
	//게시글 사진 상세조회
	   @RequestMapping("/empFile/{empFileId}")
	   public ResponseEntity<byte[]> getEmpFile(@PathVariable int empFileId){
	      EmpUploadFile empfile = empBoardService.getEmpFile(empFileId);
//	      System.out.println("파일"+empfile);
	      logger.info("getFile " + empfile.toString());
	      final HttpHeaders headers = new HttpHeaders();
	      String[] mtypes = empfile.getEmpFileContent().split("/");
	      headers.setContentType(new MediaType(mtypes[0], mtypes[1]));
	      headers.setContentLength(empfile.getEmpFileSize());
	      headers.setContentDispositionFormData("attachment", empfile.getEmpFileName(), Charset.forName("UTF-8"));
	      return new ResponseEntity<byte[]>(empfile.getEmpFileData(), headers, HttpStatus.OK);
	   }

	@RequestMapping("/empBoard/details/{empId}")
	public String getEmpBoardDetails(@PathVariable int categoryId, @PathVariable int empId, Model model, HttpSession session) {
		return getEmpBoardDetails(categoryId, empId, 1, model, session);			
	}

	 //게시글 등록 GET
	   @RequestMapping(value="/empBoard/insert/{categoryId}", method=RequestMethod.GET)
	   public String insertEmpBoardArticle(@PathVariable int categoryId, Model model,HttpSession session) {
	      String categoryName = boardCategoryService.getCategoryName(categoryId);
	      model.addAttribute("categoryId", categoryId);
	      model.addAttribute("categoryName", categoryName);
	      model.addAttribute("userId", session.getAttribute("userId")); //로그인 연결했을때 확인
	      return "empboard/empBoardInsert";
	   }
	//게시글 등록 POST
	@RequestMapping(value="/empBoard/insert", method=RequestMethod.POST)
	public String insertEmpBoardArticle(EmpBoard empBoard, BindingResult result, RedirectAttributes redirectAttrs) {
		logger.info("/empboard/insert : " + empBoard.toString());
		try {
			empBoard.setEmpBoardTitle(Jsoup.clean(empBoard.getEmpBoardTitle(), Whitelist.basic()));
			empBoard.setEmpBoardContent(Jsoup.clean(empBoard.getEmpBoardContent(), Whitelist.basic()));
			MultipartFile mfile = empBoard.getEmpFile();
			System.out.println("1234567890");
			if(mfile!=null && !mfile.isEmpty()) {
				logger.info("/empBoard/insert : " + mfile.getOriginalFilename());
				EmpUploadFile empFile = new EmpUploadFile();
				empFile.setEmpFileName(mfile.getOriginalFilename());
				empFile.setEmpFileSize(mfile.getSize());
				empFile.setEmpFileContent(mfile.getContentType());
				empFile.setEmpFileData(mfile.getBytes());
				logger.info("/empBoard/insert : " + empFile.toString());

				empBoardService.insertEmpBoardArticle(empBoard, empFile);
			}else {
				empBoardService.insertEmpBoardArticle(empBoard);
				System.out.println("12345678900000000");
				
			}
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/empBoard/cat/"+empBoard.getCategoryId();
	}
	//게시글 수정 GET
	@RequestMapping(value="/empBoard/update/{categoryId}/{empId}", method=RequestMethod.GET) 
	public String updateEmpBoardArticle(@PathVariable int empId,@PathVariable int categoryId, Model model) {
		String categoryName = boardCategoryService.getCategoryName(categoryId);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("categoryName", categoryName);
		
		EmpBoard empBoard = empBoardService.selectEmpBoardArticle(empId, categoryId); 
		logger.info("/empBoard/update/"+empBoard.toString());
		model.addAttribute("empBoard", empBoard);
		return "empboard/empBoardUpdate"; 
	}

	//게시글 수정 POST
	@RequestMapping(value="/empBoard/update", method=RequestMethod.POST)
	public String updateEmpBoardArticle(EmpBoard empBoard, BindingResult result, HttpSession session, 
			RedirectAttributes redirectAttrs) {
		logger.info("/empBoard/update " + empBoard.toString()); 
		try{
			empBoard.setEmpBoardTitle(Jsoup.clean(empBoard.getEmpBoardTitle(),Whitelist.basic()));
			empBoard.setEmpBoardContent(Jsoup.clean(empBoard.getEmpBoardContent(),Whitelist.basic()));
			MultipartFile mfile = empBoard.getEmpFile();
			if(mfile!=null && !mfile.isEmpty()) {
				logger.info("/empBoard/update : " + mfile.getOriginalFilename());
				EmpUploadFile empFile = new EmpUploadFile();
				empFile.setEmpFileId(empBoard.getEmpFileId());
				empFile.setEmpFileName(mfile.getOriginalFilename());
				empFile.setEmpFileSize(mfile.getSize());
				empFile.setEmpFileContent(mfile.getContentType());
				empFile.setEmpFileData(mfile.getBytes());
				logger.info("/empBoard/update : " + empFile.toString());
				empBoardService.updateEmpBoardArticle(empBoard, empFile);
			}else {
				empBoardService.updateEmpBoardArticle(empBoard);
			}
		}catch(Exception e) {
			e.printStackTrace();
			redirectAttrs.addFlashAttribute("message",e.getMessage());
		}
		return "redirect:/empBoard/details/"+empBoard.getCategoryId() +"/"+empBoard.getEmpId() +"/1"; 
	}


	
	//게시글 삭제 
	@RequestMapping(value="/empBoard/delete/{categoryId}/{empId}", method=RequestMethod.GET)
	public String deleteEmpBoardArticle(@PathVariable int categoryId,@PathVariable int empId, EmpBoard empBoard, BindingResult result, HttpSession session, Model model) {
		logger.info("/empBoard/delete : " + empBoard.toString());
		empBoardService.deleteEmpBoardArticle(empId);
		return "redirect:/empBoard/cat/" + empBoard.getCategoryId() + "/" + (Integer)session.getAttribute("page");
	}
	//키워드 검색
	@RequestMapping("/empBoard/search/{page}")
	public String search(@RequestParam(required=false, defaultValue="") String keyword, @PathVariable int page, 
			HttpSession session, Model model) {
		try {
			List<EmpBoard> empBoardList =
					empBoardService.searchEmpBoardListByContentKeyword(keyword, page);
			model.addAttribute("empBoardList",empBoardList);

			//paging start
			int bbsCount = 
					empBoardService.selectEmpBoardTotalArticleCountByKeyword(keyword);
			int totalPage = 0;
			System.out.println(bbsCount);
			if(bbsCount > 0) {
				totalPage= (int)Math.ceil(bbsCount/10.0);
			}
			model.addAttribute("totalPageCount",totalPage);
			model.addAttribute("page",page);
			model.addAttribute("keyword",keyword);
			logger.info(totalPage + ":" + page + ":" + keyword);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "empboard/empBoardSearch";
	}



}
