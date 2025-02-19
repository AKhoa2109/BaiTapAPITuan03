package com.android.APILogin.service;

import com.android.APILogin.entity.Document;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;

public interface IProductService {
    public List<Document> findAllByCategory(Long id);
    public List<Object[]> findTop10BestSellerProduct();
    public List<Document> findTop10NewestProduct();
}
