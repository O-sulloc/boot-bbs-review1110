package com.bbs.review1110.domain.repository;

import com.bbs.review1110.domain.entity.Hospital;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    @Autowired
    HospitalRepository hospitalRepository;

    @Test
    void findByTypeAndRegion() {
        // 6. 지역구 + 보건소

        List<String> category = new ArrayList<>();

        String region = "노원구";
        category.add("보건소");
        category.add("보건진료소");
        category.add("보건지소");

        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameInAndRoadNameAddressContaining(category,region);
        for (Hospital hospital : hospitals) {
            System.out.printf("%s, %s, %s \n", hospital.getHospitalName(), hospital.getBusinessTypeName(), hospital.getRoadNameAddress());
        }
    }

    //@Test
    void findByBeds() {
        //5. patient room이 10개 이상 20개 이하에 해당하는 병원 찾기 (병실수 오름차순 정렬)
        List<Hospital> hospitals = hospitalRepository.findByPatientRoomCountBetweenOrderByPatientRoomCountAsc(10, 20);

        for (Hospital hospital : hospitals) {
            System.out.printf("%s %d개\n", hospital.getHospitalName(), hospital.getPatientRoomCount());
        }
    }

    //@Test
    void findByWord2() {
        // 4. 특정 단어로 끝나는 병원 조회하기
        String word = "치과";
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameEndsWith(word);

        for (Hospital hospital : hospitals) {
            System.out.printf("%s\n", hospital.getHospitalName());
        }
    }

    //@Test
    void findByWord() {
        // 3. 특정 단어로 시작하는 병원 조회하기
        String word = "경희";
        List<Hospital> hospitals = hospitalRepository.findByHospitalNameStartsWith(word);

        for (Hospital hospital : hospitals) {
            System.out.printf("%s\n", hospital.getHospitalName());
        }
    }

    //@Test
    @DisplayName("특정구 검색하기")
    void findByAddress() {
        // 2. 특정구에 위치한 병원 조회하기
        String region = "노원구";
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContaining(region);
        for (Hospital hospital : hospitals) {
            System.out.printf("%s, %s \n", hospital.getHospitalName(), hospital.getRoadNameAddress());
        }
    }

    //@Test
    @DisplayName("보건진료소, 보건지소, 보건소 모두 찾기")
    void findByName() {
        // 1. businessTypeName에 보건진료소, 보건지소, 보건소 들어간 병원 찾기
        List<String> category = new ArrayList<>();
        category.add("보건소");
        category.add("보건진료소");
        category.add("보건지소");

        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(category);
        for (Hospital hospital : hospitals) {
            System.out.printf("%s, %s, %s \n", hospital.getHospitalName(), hospital.getBusinessTypeName(), hospital.getRoadNameAddress());
        }
    }
/*
    @Test
    void printHospitalNameAndAddress(List<Hospital> hospitals) {
        for (var hospital : hospitals) {
            System.out.printf("%s | %s %f\n", hospital.getHospitalName(), hospital.getRoadNameAddress(),
                    hospital.getTotalAreaSize());
        }
        System.out.println(hospitals.size());
    }

    @Test
    @DisplayName("BusinessTypeName이 보건소 보건지소 보건진료소인 데이터가 잘 나오는지")
    void findByBusinessTypeNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        List<Hospital> hospitals = hospitalRepository.findByBusinessTypeNameIn(inClues);
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    @DisplayName("주소 + 업태 구분명으로 검색")
    void findByAddressContainsAndBusinessTypNameIn() {
        List<String> inClues = new ArrayList<>();
        inClues.add("보건소");
        inClues.add("보건지소");
        inClues.add("보건진료소");
        String address = "인천광역시";
        List<Hospital> hospitals = hospitalRepository.findByRoadNameAddressContainsAndBusinessTypeNameIn(address, inClues);
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    @DisplayName("병상 수가 10개 이상 20개 미만 병원 찾기 - ~Than")
    void findByTotalNumberOfBeds() {
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsGreaterThanEqualAndTotalNumberOfBedsLessThan(10, 20);
        printHospitalNameAndAddress(hospitals);
    }

    @Test
    @DisplayName("병상 수가 10개 이상 20개 미만 병원 찾기 - Between ")
    void findByTotalNumberOfBedsWithBetween() {
        List<Hospital> hospitals = hospitalRepository.findByTotalNumberOfBedsBetween(10, 19);
        printHospitalNameAndAddress(hospitals);
    }
    */

}