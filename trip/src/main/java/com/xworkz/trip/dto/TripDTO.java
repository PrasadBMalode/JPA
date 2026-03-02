package com.xworkz.trip.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDTO {

    private Integer id;
    private Integer age;
    private String name;
    private String cllgName;
    private String location;
    private String gender;
    private String className;
    private String email;
    private String contactNumber;
}
