package com.hms.hms.rest;

import com.hms.hms.service.HmsService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class HmsRestController {

    @Autowired
    HmsService hmsService;

    @GetMapping("/facilities/{city}/{street}")
    public List<String> getHospitalFeatures(@NonNull @PathVariable String city, @NonNull @PathVariable String street) {

        return hmsService.getFacilities(city, street);
    }
}
