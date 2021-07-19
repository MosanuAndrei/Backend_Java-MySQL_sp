package com.platform.java.service;

import com.platform.java.entity.Category;
import com.platform.java.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repo;

    public boolean updateCategoryDB(Category c1){
        Category saved = repo.save(c1);
        if(saved != null){
            return true;
        }
        else{
            return false;
        }
    }
}
