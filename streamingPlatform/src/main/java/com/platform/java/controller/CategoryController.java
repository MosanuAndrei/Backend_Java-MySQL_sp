package com.platform.java.controller;

import com.platform.java.entity.Category;
import com.platform.java.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService service;

    @CrossOrigin
    @PutMapping("/category/update/{id}")
    public String updateCategory(@PathVariable("id") int id, @RequestBody Category c1){
        c1.setIdCategory(id);
        if(service.updateCategoryDB(c1)){
            return "Success!";
        }
        else{
            return "Failed!";
        }
    }
}
