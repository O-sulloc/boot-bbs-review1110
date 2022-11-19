package com.bbs.review1110.controller;

import com.bbs.review1110.domain.entity.HospitalResponse;
import com.bbs.review1110.service.HospitalService;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HospitalRestController.class) //가짜로 테스트 돌려보는거??
class HospitalRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    HospitalService hospitalService;

    @Test
    @DisplayName("데이터가 1개의 json 형태로 잘 오는지")
    void JsonResponse() throws Exception {
//        HospitalResponse hospitalResponse
//                = new HospitalResponse(2321, "노소아청소년과의원", "서울특별 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)","영업중");

        //빌더로 넣으면 더 간편함 (위에 방식은 좀 귀찮음. 매개 변수 순서대로 데이터 넣느라 신경써야되고)
        HospitalResponse hospitalResponse = HospitalResponse.builder()
                .id(2321)
                .roadNameAddress("서울특별 서초구 서초중앙로 230, 202호 (반포동, 동화반포프라자빌딩)")
                .hospitalName("노소아청소년과의원")
                .hospitalStatusName("영업중")
                .build();

        given(hospitalService.getInfo(2321)).willReturn(hospitalResponse);

        int hospitalId = 2321;
        String url = String.format("/api/v1/hospitals/%d",hospitalId);

        mockMvc.perform(get(url)) //예외처리
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hospitalName").exists())
                //{"id":1,"roadNameAddress":"광주광역시 북구 동문대로 24, 3층 (풍향동)"} 이런식으로 key,value의 json형태로 받은 데이터 중 하나의 값을 확인해보는 것
                //hospital name이 존재하는지 expect 해봄
                .andExpect(jsonPath("$.hospitalName").value("노소아청소년과의원"))
                .andExpect(jsonPath("$.businessStatusName").exists())
                .andExpect(jsonPath("$.businessStatusName").value("영업중"))
                .andDo(print()); //결과를 콘솔창에 출력

        verify(hospitalService).getInfo(hospitalId);
    }
}