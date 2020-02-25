package com.example.demo.entity;


public class CategoryDTO {
    private int CategoryID;
    private String CategoryName;

    public CategoryDTO() {
    }

    public CategoryDTO(String categoryName, int categoryID) {
        CategoryID = categoryID;
        CategoryName = categoryName;
    }
    public CategoryDTO(String categoryName) {
        CategoryName = categoryName;
    }


    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }
}
