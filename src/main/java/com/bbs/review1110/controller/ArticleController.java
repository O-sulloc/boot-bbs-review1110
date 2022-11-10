package com.bbs.review1110.controller;

import com.bbs.review1110.domain.ArticleDTO;

import com.bbs.review1110.domain.entity.Article;
import com.bbs.review1110.domain.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    private ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("/add")
    public String getForm() {
        return "article/add";
    }

    @PostMapping("")
    public String setAdd(ArticleDTO articleDTO) {
        //log.info(articleDTO.getTitle());
        //log.info(articleDTO.getContents());

        articleRepository.save(articleDTO.toEntity());

        return "redirect:/article/add";
    }

    @GetMapping("/detail/{id}")
    public String getOne(@PathVariable Long id, Model model) {
        Optional<Article> article = articleRepository.findById(id);

        if (!article.isEmpty()) {
            model.addAttribute("article", article.get());

            return "/article/detail";
        }else{

            return "/article/error";
        }
    }
}
