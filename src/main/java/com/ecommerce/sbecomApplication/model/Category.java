package com.ecommerce.sbecomApplication.model;

import lombok.Data;

@Data
public class Category {
    private long categoryId;
    private String categoryName;
    public Category(long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }


}
