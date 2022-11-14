package com.bbs.review1110.domain.repository;

import com.bbs.review1110.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
