package com.bbs.review1110.service;

import com.bbs.review1110.domain.ArticleDTO;
import com.bbs.review1110.domain.entity.Article;
import com.bbs.review1110.domain.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleDTO getOne(Long id) {
        //Optional<Article> optionalArticle = articleRepository.findById(id);

        //ArticleDTO articleDTO = Article.ToDTO(optionalArticle.get());

        //article을 articleDTO로 형변환해줘야 함.

        //return articleDTO;
        return null;
    }
}
