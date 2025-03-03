package com.hms.hms.service;

import com.hms.hms.repository.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HmsService {
    @Autowired
    FacilityRepository facilityRepository;

    public List<String> getFacilities(String city, String street) {

    }
}
