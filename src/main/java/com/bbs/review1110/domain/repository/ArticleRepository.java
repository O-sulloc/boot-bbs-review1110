package com.bbs.review1110.domain.repository;

import com.bbs.review1110.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
