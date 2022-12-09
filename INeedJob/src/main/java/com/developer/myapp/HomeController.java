package com.developer.myapp;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developer.myapp.empboard.model.EmpBoard;
import com.developer.myapp.empboard.service.IEmpBoardService;
import com.developer.myapp.empboard.service.impl.EmpBoardService;
import com.developer.myapp.jobhunterboard.model.JHBoard;
import com.developer.myapp.jobhunterboard.service.IJHBoardService;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IEmpBoardService empBoardService;
	
	@Autowired
	IJHBoardService jhBoardService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		List<EmpBoard> empBoardList =
				empBoardService.selectEmpBoardArticleListByCategory(1, 1);
		model.addAttribute("empBoardList", empBoardList);
		
		
		List<JHBoard> jhBoardList = jhBoardService.selectJHBoardArticleListByCategory(5, 1);
		model.addAttribute("jhBoardList", jhBoardList);
			
		return "home";
	}
	
}
