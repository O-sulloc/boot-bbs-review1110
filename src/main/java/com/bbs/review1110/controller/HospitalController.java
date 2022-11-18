package com.bbs.review1110.controller;

import com.bbs.review1110.domain.entity.Hospital;
import com.bbs.review1110.domain.repository.HospitalRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hospital")
@Slf4j
public class HospitalController {

    private HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/list")
    public String getList(Model model, Pageable pageable) {
        Page<Hospital> hospitalList = hospitalRepository.findAll(pageable);
        model.addAttribute("hospitalList", hospitalList);
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next", pageable.next().getPageNumber());

        return "hospital/list";
    }


    @GetMapping("/detail/{id}")
    public String getOne(@PathVariable Integer id, Model model) {
        Optional<Hospital> hospital = hospitalRepository.findById(id);
        model.addAttribute("hospital",hospital.get());

        return "hospital/detail";
    }

}
