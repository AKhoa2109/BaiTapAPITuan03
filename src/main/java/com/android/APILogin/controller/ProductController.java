package com.android.APILogin.controller;

import com.android.APILogin.entity.Document;
import com.android.APILogin.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/get-product")
    public ResponseEntity<?> getAllProductByCategory(@Validated  @RequestParam("id") Long id) {
        List<Document> documents = productService.findAllByCategory(id);
        if(documents == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(documents);
        }
    }

    @GetMapping(path = "/top-seller")
    public ResponseEntity<?> getTopSellerProduct()
    {
        List<Document> documents = new ArrayList<>();
        List<Object[]> topSeller = productService.findTop10BestSellerProduct();
        for(Object[] p : topSeller) {
            documents.add((Document) p[0]);
        }
        if(documents == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(documents);
        }
    }

    @GetMapping(path = "/top-newest")
    public ResponseEntity<?> getTopNewestProduct(){
        List<Document> documents = productService.findTop10NewestProduct();
        if(documents == null) {
            return ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.ok(documents);
        }
    }


}
