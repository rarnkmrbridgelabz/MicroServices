package com.bridgelabz.microservices.vaccinationcenter.controllers;

import java.util.List;

import com.bridgelabz.microservices.vaccinationcenter.entity.VaccinationCenter;
import com.bridgelabz.microservices.vaccinationcenter.model.Citizen;
import com.bridgelabz.microservices.vaccinationcenter.model.RequiredResponse;
import com.bridgelabz.microservices.vaccinationcenter.repos.CenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/vaccinationcenter")
public class VaccinationCenterController {

    @Autowired
    private CenterRepo centerRepo;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(path = "/add")
    public ResponseEntity<VaccinationCenter> addVaccinationCentre(@RequestBody VaccinationCenter vaccinationCenter) {
        VaccinationCenter vaccinationCenterAdded = centerRepo.save(vaccinationCenter);
        return new ResponseEntity<>(vaccinationCenterAdded, HttpStatus.OK);
    }

    @GetMapping(path = "/id/{id}")
    public ResponseEntity<RequiredResponse> getAllDadaBasedonCenterId(@PathVariable Integer id){
        RequiredResponse requiredResponse =  new RequiredResponse();

        VaccinationCenter center  = centerRepo.findById(id).get();
        requiredResponse.setCenter(center);

        java.util.List<Citizen> listOfCitizens = restTemplate.getForObject("http://CITIZEN-SERVICE/citizen/id/"+id, List.class);
        requiredResponse.setCitizens(listOfCitizens);
        return new ResponseEntity<RequiredResponse>(requiredResponse, HttpStatus.OK);
    }


}
