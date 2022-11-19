package com.bbs.review1110.controller;

import com.bbs.review1110.domain.entity.Hospital;
import com.bbs.review1110.domain.entity.HospitalResponse;
import com.bbs.review1110.domain.repository.HospitalRepository;
import com.bbs.review1110.service.HospitalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalRestController {

    //private final HospitalRepository hospitalRepository;
    //이제 repository 말고 service를 쓸거임. (service가 Repository 쓰는 비즈니스 로직 담당)

    private final HospitalService hospitalService;

    public HospitalRestController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<HospitalResponse> get(@PathVariable Integer id){
//        Optional<Hospital> hospital = hospitalRepository.findById(id);
//        return ResponseEntity.ok().body(Hospital.of(hospital.get()));
        //이 로직은 이제 서비스에서 담당하기 때문에 필요 없음

        return ResponseEntity.ok().body(hospitalService.getInfo(id)); //service에서 받은 것만 리턴해주면 끝
    }
}
