package com.bbs.review1110.controller;

import com.bbs.review1110.domain.ArticleDTO;
import com.bbs.review1110.domain.entity.Article;
import com.bbs.review1110.service.ArticleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private static ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getOne(@PathVariable Long id) {
        //restController에서는 Response 형태로 소통한다.

        ArticleDTO articleDTO = articleService.getOne(id);
        //service에서 받아온 걸 articleDTO에 넣어줘

        return ResponseEntity.ok().body(articleDTO); //그걸 body에 넣어서 json 형태로 보내줘
    }
}
