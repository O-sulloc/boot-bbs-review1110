package com.bbs.review1110.domain;

import com.bbs.review1110.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDTO {

    private String title;
    private String contents;

    public Article toEntity() {
        return new Article(this.title, this.contents);
    }
}
