package com.bbs.review1110.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticleResponse {
    private Long id;
    private String title;
    private String contents;
}
