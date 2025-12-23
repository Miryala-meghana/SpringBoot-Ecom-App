package com.ecommerce.sbecomApplication.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Category {
    // Change 'long' to 'Long' (the wrapper class)
    private Long categoryId;
    private String categoryName;

    // Update constructor to use Long as well
    public Category(Long categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
}