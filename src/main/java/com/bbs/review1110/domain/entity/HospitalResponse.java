package com.bbs.review1110.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@Builder
public class HospitalResponse {
    private Integer id; //int는 Integer Long은 bigint
    private String roadNameAddress;
    private String hospitalName;
    private String hospitalStatusName; // status_code가 13이면 '영업중' 이라고 문자로 리턴해 줄 것임

    private String openServiceName;
    private Integer openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private Integer businessStatus;
    private Integer businessStatusCode;
    private String phone;
    private String fullAddress;

    private String businessTypeName;
    private Integer healthcareProviderCount;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private float totalAreaSize;

    public HospitalResponse(Integer id, String hospitalName, String roadNameAddress) {
        this.id = id;
        this.hospitalName = hospitalName;
        this.roadNameAddress = roadNameAddress;
    }

    public void setHospitalStatusName(String hospitalStatusName) {
        this.hospitalStatusName = hospitalStatusName;
    }
}
