package com.example.demo.entity;

public class InventoryListDTO {

    private int ProductID;
    private String ProductName;
    private String CategoryName;

    public InventoryListDTO() {
    }

    public InventoryListDTO(String productName, String categoryName) {
        ProductName = productName;
        CategoryName = categoryName;
    }

    public InventoryListDTO(int productID, String productName, String categoryName) {
        ProductID = productID;
        ProductName = productName;
        CategoryName = categoryName;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int productID) {
        ProductID = productID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

}
