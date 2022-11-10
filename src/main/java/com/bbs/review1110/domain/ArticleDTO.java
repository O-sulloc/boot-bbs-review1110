package com.bbs.review1110.domain;

import com.bbs.review1110.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDTO {
    private Long id; //update할 때 필요, toEntity에도 추가해줘

    private String title;
    private String contents;

    public Article toEntity() {
        return new Article(this.id, this.title, this.contents);
    }
}
