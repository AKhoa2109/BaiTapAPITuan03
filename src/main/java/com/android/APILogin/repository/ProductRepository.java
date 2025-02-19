package com.android.APILogin.repository;

import com.android.APILogin.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Document,Long> {
    List<Document> findByCategory_CategoryId(Long categoryId);

    @Query("SELECT od.document, SUM(od.quantity) as totalQuantity FROM OrderDetail od GROUP BY od.document ORDER BY totalQuantity DESC limit 10")
     List<Object[]> findTop10BestSellerProduct();

    @Query("SELECT d FROM Document d where d.created_at <= :dayLast order by d.created_at desc limit 10")
    List<Document> findTop10NewestProduct(@Param("dayLast")LocalDateTime dayLast);
}
