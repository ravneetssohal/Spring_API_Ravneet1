package com.pragra.spring_api_ravneet1.service;

import com.pragra.spring_api_ravneet1.entity.HospitalDTO;
import com.pragra.spring_api_ravneet1.repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    private HospitalRepo hospitalRepo;

    public List<HospitalDTO> getAll(){
        return hospitalRepo.findAll();
    }

    public void addNurse(HospitalDTO hospitalDTO){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(hospitalDTO.getNursePassword());
        hospitalDTO.setNursePassword(encodedPassword);
        hospitalRepo.save(hospitalDTO);
    }

    public void deleteNurse(Integer id){
        hospitalRepo.deleteById(id);
    }

    public List<HospitalDTO> getByFirstName(String firstName){
        return hospitalRepo.getByFirstName(firstName);
    }

    public Page<HospitalDTO> getByPage(Integer page){
        Pageable pageable = PageRequest.of(page, 5);
        return hospitalRepo.findAll(pageable);
    }
}
