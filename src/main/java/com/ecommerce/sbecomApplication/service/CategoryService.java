package com.ecommerce.sbecomApplication.service;

import com.ecommerce.sbecomApplication.model.Category;
import com.ecommerce.sbecomApplication.repository.CategoryRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@Data
@NoArgsConstructor
public class CategoryService {

    @Autowired
    public CategoryRepo categroyRepo;

    public List<Category> getAllCategories()
    {

        return categroyRepo.findAll();
    }

    public void createCategory(Category category)
    {
        categroyRepo.save(category);
    }

    public String deleteCategory(Long categoryId) {
        List<Category> categories=categroyRepo.findAll();
        Category category=categories.stream()
                .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
                .findFirst()
//                .orElse(null); //this is used when we are assigning to null and usinf IF cond
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Category not found"));//here we are directly throwing exp

//        if(category==null)
//        {
//            return "category not found";
//        }
//        categories.remove(category);
        categroyRepo.delete(category);
        return "Category with id:"+categoryId+" is deleted";
    }


    public Category updateCategory(Category category, Long categoryId) {

        List<Category> categories=categroyRepo.findAll();
        Optional<Category> Optionalcategory= Optional.of(categories.stream()
                .filter(c -> Objects.equals(c.getCategoryId(), categoryId))
                .findFirst().get());
        if(Optionalcategory.isPresent())
        {
            Category existingCat=Optionalcategory.get();
            existingCat.setCategoryName(category.getCategoryName());
            Category savedCategory=categroyRepo.save(existingCat);
            return savedCategory;
        }
        return null;
    }
}
