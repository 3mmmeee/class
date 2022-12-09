package com.developer.myapp.category.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.developer.myapp.category.dao.IBoardCategoryRepository;
import com.developer.myapp.category.model.BoardCategory;

@Service
public class BoardCategoryService implements IBoardCategoryService {
   
   @Autowired
   IBoardCategoryRepository boardCategoryRepository;

   
   @Override
   public List<BoardCategory> selectAllCategory() {
      return boardCategoryRepository.selectAllCategory();
   }
   
      
   public List<BoardCategory> list(int type){
      
      return boardCategoryRepository.list(type);
   }
   
   public List<BoardCategory> list2(){
      
      return boardCategoryRepository.list2();
   }


	@Override
	public String getCategoryName(int categoryId) {
		return boardCategoryRepository.getCategoryName(categoryId);
	}

}