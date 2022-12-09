package com.developer.myapp.category.model;

public class BoardCategory {
   private int categoryId; //카테고리 아이디
   private String categoryName; //카테고리 이름
   private int categoryOrder; //카테고리를 출력할때의 순서
   private int type; // 현업자=1, 취준생은 2번
   public int getCategoryId() {
      return categoryId;
   }
   public void setCategoryId(int categoryId) {
      this.categoryId = categoryId;
   }
   public String getCategoryName() {
      return categoryName;
   }
   public void setCategoryName(String categoryName) {
      this.categoryName = categoryName;
   }
   public int getCategoryOrder() {
      return categoryOrder;
   }
   public void setCategoryOrder(int categoryOrder) {
      this.categoryOrder = categoryOrder;
   }
   public int getType() {
      return type;
   }
   public void setType(int type) {
      this.type = type;
   }
   @Override
   public String toString() {
      return "BoardCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryOrder="
            + categoryOrder + ", type=" + type + "]";
   }
   
   

}