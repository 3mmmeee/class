package com.developer.myapp.category.service;

import java.util.List;

import com.developer.myapp.category.model.BoardCategory;

public interface IBoardCategoryService {
   
   List<BoardCategory> selectAllCategory();
    List<BoardCategory> list(int type);
    List<BoardCategory> list2();
//   void insertNewCategory(BoardCategory BoardCategory);
//   void updateCategory(BoardCategory BoardCategory);
//   void deleteCategory(BoardCategory BoardCategory);
	String getCategoryName(int categoryId);

}