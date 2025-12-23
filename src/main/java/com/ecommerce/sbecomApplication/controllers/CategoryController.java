package com.ecommerce.sbecomApplication.controllers;

import com.ecommerce.sbecomApplication.model.Category;
import com.ecommerce.sbecomApplication.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {

    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
//        List<Category> categories = categoryService.getAllCategories();
//        return new ResponseEntity<>(categories, HttpStatus.OK);
        return categoryService.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category added successfully",HttpStatus.CREATED);
    }
//    simple handling of del category
//    @DeleteMapping("/api/public/delete/{categoryId}")
//    public String deleteCategory(@PathVariable Long categoryId)
//    {
//
//            String status = categoryService.deleteCategory(categoryId);
//        return status;
//    }

    @DeleteMapping("/api/admin/delete/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId)
    {
        try {
            String status = categoryService.deleteCategory(categoryId);
            return new ResponseEntity<>(status, HttpStatus.OK);
        }
        catch (ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

    @PutMapping("/api/public/categories/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,@PathVariable Long categoryId)
    {
        try{
            Category savedCat=categoryService.updateCategory(category,categoryId);
            return new ResponseEntity<>("Category with id "+categoryId+" is updated successfully",HttpStatus.OK);
        }
        catch (ResponseStatusException e)
        {
            return new ResponseEntity<>(e.getReason(),e.getStatusCode());
        }
    }

}
