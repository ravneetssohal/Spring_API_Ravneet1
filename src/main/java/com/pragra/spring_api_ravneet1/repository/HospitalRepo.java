package com.pragra.spring_api_ravneet1.repository;

import com.pragra.spring_api_ravneet1.entity.HospitalDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepo extends JpaRepository<HospitalDTO, Integer> {

    @Query(value = "SELECT nurse FROM HospitalDTO nurse WHERE nurse.nurseFirstName = ?1")
    public List<HospitalDTO> getByFirstName(String firstName);

}
