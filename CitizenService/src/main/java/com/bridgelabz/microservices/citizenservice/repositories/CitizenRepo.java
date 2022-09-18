package com.bridgelabz.microservices.citizenservice.repositories;

import java.util.List;
import com.bridgelabz.microservices.citizenservice.entity.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepo extends JpaRepository<Citizen, Integer>{

    public List<Citizen> findByVaccinationCenterId(Integer id);

}