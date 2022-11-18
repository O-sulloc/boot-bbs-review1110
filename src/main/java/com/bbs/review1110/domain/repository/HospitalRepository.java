package com.bbs.review1110.domain.repository;

import com.bbs.review1110.domain.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
    List<Hospital> findByBusinessTypeNameIn(List<String> businessTypes);
    // 1. 보건진료소, 보건지소, 보건소 모두 찾기 (업태구분명=businessTypeName 으로 검색)

    List<Hospital> findByRoadNameAddressContaining(String region);
    // 2. 특정 구(region)에 있는 병원 찾기

    List<Hospital> findByHospitalNameStartsWith(String word);
    // 3. 특정 문자로 시작하는 병원 찾기

    List<Hospital> findByHospitalNameEndsWith(String word);
    // 4. 특정 문자로 끝나는 병원 찾기

    List<Hospital> findByPatientRoomCountBetweenOrderByPatientRoomCountAsc(int start, int end);
    // 5. 병실수 x개 이상 y개 이하에 해당하는 병원 찾기(병실수 오름차순 정렬)

    List<Hospital> findByBusinessTypeNameInAndRoadNameAddressContaining(List<String> businessTypes, String region);
    // 6. (1. 보건진료소, 보건지소, 보건소 모두 찾기 (업태구분명=businessTypeName 으로 검색)) + (2. 특정 구(region)에 있는 병원 찾기)
}
