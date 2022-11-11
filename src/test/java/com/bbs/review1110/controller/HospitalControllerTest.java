package com.bbs.review1110.controller;

import com.bbs.review1110.domain.entity.Hospital;
import com.bbs.review1110.domain.repository.HospitalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class HospitalControllerTest {

    @Autowired
    HospitalRepository hospitalRepository;

    //@Test
    void getOne() {
        Optional<Hospital> hospital = hospitalRepository.findById(1);

        Hospital hp1 = hospital.get();
        System.out.println(hp1.getHospitalName());

        assertEquals(1, hp1.getId());
    }
}