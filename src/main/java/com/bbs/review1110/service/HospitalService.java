package com.bbs.review1110.service;

import com.bbs.review1110.domain.entity.Hospital;
import com.bbs.review1110.domain.entity.HospitalResponse;
import com.bbs.review1110.domain.repository.HospitalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
public class HospitalService {
    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public HospitalResponse getInfo(Integer id){
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        Hospital hospital = optHospital.get(); // hospital은 business status code를 받고 (13)

        HospitalResponse hospitalResponse = Hospital.of(hospital); //service와 controller는 hospitalResponse 객체를 소통하니까 거기에 담아줘
        //hospital Response는 business status name을 받음 (string 값인 "영업중")

        if(hospital.getBusinessStatusCode() == 13){
            hospitalResponse.setHospitalStatusName("영업중");
        } else if(hospital.getBusinessStatusCode() == 3) {
            hospitalResponse.setHospitalStatusName("폐업");
        }else{
            hospitalResponse.setHospitalStatusName(String.valueOf(hospital.getBusinessStatusCode())); //13,3 아니면 그냥 그 숫자 그대로 넣어줘
        }

        /* switch로 표현하면 아래와 같음
        switch (hospitalResponse.getBusinessStatusCode()){
            case 13: hospitalResponse.setHospitalStatusName("영업중");break;
            case 3: hospitalResponse.setHospitalStatusName("폐업");break;
            case 4: hospitalResponse.setHospitalStatusName("");break;
            case 24: hospitalResponse.setHospitalStatusName("");break;
        }
         */


        return hospitalResponse;
    }
}
