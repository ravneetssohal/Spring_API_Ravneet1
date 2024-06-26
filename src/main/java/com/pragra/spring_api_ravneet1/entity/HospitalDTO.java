package com.pragra.spring_api_ravneet1.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class HospitalDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nurseID;
    private String nurseFirstName;
    private String nurseLastName;
    private String nursePassword;
    private String nursePhoneNo;
    private Integer nurseSalary;
}
