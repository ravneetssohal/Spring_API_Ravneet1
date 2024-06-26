package com.pragra.spring_api_ravneet1.controller;

import com.pragra.spring_api_ravneet1.entity.HospitalDTO;
import com.pragra.spring_api_ravneet1.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital")
public class HospitalController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/all")
    public List<HospitalDTO> getAll(){
        return hospitalService.getAll();
    }

    @PostMapping("/add")
    public HospitalDTO addNurse(@RequestBody HospitalDTO hospitalDTO){
        hospitalService.addNurse(hospitalDTO);
        return hospitalDTO;
    }

    @DeleteMapping("/delete")
    public String deleteNurse(@RequestParam Integer id){
        hospitalService.deleteNurse(id);
        return "Deleted Successfully!";
    }

    @GetMapping("/getByFirstName")
    public List<HospitalDTO> getByFirstName(@RequestParam String firstName){
        return hospitalService.getByFirstName(firstName);
    }

    @GetMapping("/viewByPage")
    public Page<HospitalDTO> getByPage(@RequestParam Integer page){
        return hospitalService.getByPage(page);
    }


}
