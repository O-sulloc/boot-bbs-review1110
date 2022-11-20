package com.bbs.review1110.domain.entity;

import com.bbs.review1110.domain.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "article4")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public static ArticleDTO ToDTO(Article article) {
        //service 에서 article을 articleDTO로 형변환하는 메서드
        return new ArticleDTO(article.getId(), article.getTitle(), article.getContents());
    }

    public static ArticleResponse ToDTO2(Article article) {

        return new ArticleResponse(article.getId(), article.getTitle(), article.getContents());
    }
}
