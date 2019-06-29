package org.greenwin.VLCampaign.controllers;

import org.greenwin.VLCampaign.model.Category;
import org.greenwin.VLCampaign.services.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/id/{id}")
    public Category getCategoryById(@PathVariable ("id") int id){
        return categoryService.getById(id);
    }

    @GetMapping("/")
    public List<Category> getAllCategories(){
        return categoryService.getAll();
    }
}
