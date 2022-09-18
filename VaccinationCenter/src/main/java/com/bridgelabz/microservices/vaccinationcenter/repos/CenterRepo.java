package com.bridgelabz.microservices.vaccinationcenter.repos;

import com.bridgelabz.microservices.vaccinationcenter.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepo extends JpaRepository<VaccinationCenter, Integer> {
}
