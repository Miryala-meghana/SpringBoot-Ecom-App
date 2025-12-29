package com.ecommerce.sbecomApplication.repository;

import com.ecommerce.sbecomApplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> { //entity,primary key
}
