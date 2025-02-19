package com.android.APILogin.controller;

import com.android.APILogin.entity.Document;
import com.android.APILogin.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Map<String,Object>> documents = new ArrayList<>();
        List<Object[]> topSeller = productService.findTop10BestSellerProduct();
        for(Object[] p : topSeller) {
            Map<String,Object> docMap = new HashMap<>();
            docMap.put("document",(Document) p[0]);
            docMap.put("total_quantity",(Long) p[1]);
            documents.add(docMap);
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
