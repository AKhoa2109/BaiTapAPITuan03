package com.android.APILogin.service.impl;

import com.android.APILogin.entity.Category;
import com.android.APILogin.repository.CategoryRepository;
import com.android.APILogin.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

}
