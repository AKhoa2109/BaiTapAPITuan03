package com.android.APILogin.service.impl;

import com.android.APILogin.entity.Document;
import com.android.APILogin.repository.ProductRepository;
import com.android.APILogin.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Document> findAllByCategory(Long id) {
        return productRepository.findByCategory_CategoryId(id);
    }

    @Override
    public List<Object[]> findTop10BestSellerProduct(){
        return productRepository.findTop10BestSellerProduct();
    }

    @Override
    public List<Document> findTop10NewestProduct(){
        LocalDateTime lastDay = LocalDateTime.now().plusDays(7);
        return productRepository.findTop10NewestProduct(lastDay);
    }
}
