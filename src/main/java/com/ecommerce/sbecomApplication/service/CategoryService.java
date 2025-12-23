package com.ecommerce.sbecomApplication.service;

import com.ecommerce.sbecomApplication.model.Category;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Data
public class CategoryService {

    private List<Category> categories=new ArrayList<>();
    public Long nextId=1L;

    public List<Category> getAllCategories()
    {
        return categories;
    }

    public void createCategory(Category category)
    {
        category.setCategoryId(nextId++);
        categories.add(category);
    }

    public String deleteCategory(Long categoryId) {
        Category category=categories.stream()
                .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
                .findFirst()
//                .orElse(null); //this is used when we are assigning to null and usinf IF cond
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));//here we are directly throwing exp

//        if(category==null)
//        {
//            return "category not found";
//        }
        categories.remove(category);
        return "Category with id:"+categoryId+" is deleted";
    }
}
