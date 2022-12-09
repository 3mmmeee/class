package com.developer.myapp.category.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.developer.myapp.category.model.BoardCategory;
import com.developer.myapp.category.service.IBoardCategoryService;

@Controller
public class BoardCategoryController {

   @Autowired
   IBoardCategoryService boardCategoryService;

   @RequestMapping(value="/category/list/{type}", method=RequestMethod.GET)
   public String getList(@PathVariable int type,Model model) throws Exception {
      // type 1= 현업자, 2= 취준생

      List<BoardCategory> list = boardCategoryService.list(type);
      List<BoardCategory> list2 = boardCategoryService.list2();
      System.out.println(list);

      model.addAttribute("list",list);
      model.addAttribute("list2",list2);
      
      return "boardcategory/BoardCategory";

   }

   //현업자 등록페이지
//   @RequestMapping(value = "/category/list2/{categoryId}",method=RequestMethod.GET)
//   public String page(int categoryId, Model model) {
//      boardCategoryService.list2(categoryId);
//      return "boardcategory/BoardCategory";
//   }



}