package com.bbs.review1110.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "nation_wide_hospital")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    private Integer id; //int는 Integer Long은 bigint
    private String openServiceName;
    private Integer openLocalGovernmentCode;
    private String managementNumber;
    private LocalDateTime licenseDate;
    private Integer businessStatus;
    private Integer businessStatusCode;
    private String phone;
    private String fullAddress;
    @Column(name = "road_name_address")
    private String roadNameAddress;
    @Column(name = "hospital_name") //칼럼 이름 특정하고 싶을 때
    private String hospitalName;
    private String businessTypeName;
    private Integer healthcareProviderCount;
    private Integer patientRoomCount;
    private Integer totalNumberOfBeds;
    private float totalAreaSize;

    public String getHospitalName() {
        return hospitalName;
    }

    public Hospital(String openServiceName, Integer openLocalGovernmentCode, String managementNumber, LocalDateTime licenseDate, Integer businessStatus, Integer businessStatusCode, String phone, String fullAddress, String roadNameAddress, String hospitalName, String businessTypeName, Integer healthcareProviderCount, Integer patientRoomCount, Integer totalNumberOfBeds, float totalAreaSize) {
        this.openServiceName = openServiceName;
        this.openLocalGovernmentCode = openLocalGovernmentCode;
        this.managementNumber = managementNumber;
        this.licenseDate = licenseDate;
        this.businessStatus = businessStatus;
        this.businessStatusCode = businessStatusCode;
        this.phone = phone;
        this.fullAddress = fullAddress;
        this.roadNameAddress = roadNameAddress;
        this.hospitalName = hospitalName;
        this.businessTypeName = businessTypeName;
        this.healthcareProviderCount = healthcareProviderCount;
        this.patientRoomCount = patientRoomCount;
        this.totalNumberOfBeds = totalNumberOfBeds;
        this.totalAreaSize = totalAreaSize;
    }
}
