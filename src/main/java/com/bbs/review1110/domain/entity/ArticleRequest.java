package com.bbs.review1110.domain.entity;

import lombok.*;

@AllArgsConstructor
//@Builder
//@Getter
//@EqualsAndHashCode
@Data
public class ArticleRequest {
    private String title;
    private String contents;

    public Article toEntity() {
        return new Article(this.title, this.contents);
    }
}
