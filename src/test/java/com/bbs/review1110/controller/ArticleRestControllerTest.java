package com.bbs.review1110.controller;

import com.bbs.review1110.domain.ArticleDTO;
import com.bbs.review1110.service.ArticleService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
    @DisplayName("Json형식으로 데이터 한 개 가져와보기")
    void getOne() throws Exception {
        ArticleDTO articleDTO = ArticleDTO.builder()
                .id(1L)
                .title("test1")
                .contents("con1")
                .build();

        given(articleService.getOne(1L)).willReturn(articleDTO);
        //article Service의 getONE ㅁㅔ서드에 1을 넣으면
        //.id(1L) .title("test1") .contents("con1")가 올거라고 예상한다?

        Long id = 1L;
        String url = String.format("/api/v1/articles/%d",id);
        mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.title").value("test1"))
                .andExpect(jsonPath("$.contents").exists())
                .andExpect(jsonPath("$.contents").value("con1"))
                .andDo(print());

        verify(articleService).getOne(1L);
    }
}