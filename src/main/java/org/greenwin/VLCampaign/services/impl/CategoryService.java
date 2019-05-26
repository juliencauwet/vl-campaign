package org.greenwin.VLCampaign.services.impl;

import org.greenwin.VLCampaign.model.Category;
import org.greenwin.VLCampaign.repository.CategoryRepository;
import org.greenwin.VLCampaign.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category getById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }
}
