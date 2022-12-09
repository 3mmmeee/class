package com.developer.myapp.category.dao;

import java.util.List;

import com.developer.myapp.category.model.BoardCategory;

public interface IBoardCategoryRepository {
   //카테고리별 현업자/취준생 리스트 : 1차 분류
   List<BoardCategory> selectAllCategory();
   List<BoardCategory> list(int type);
   
   //카테고리별 리스트 : 2차 분류
   List<BoardCategory> list2();
   
   String getCategoryName(int categoryId);

   //List<BoardCategory> list2(int type);
}