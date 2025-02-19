package com.android.APILogin.controller;

import com.android.APILogin.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> getAllCategory() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }


}
