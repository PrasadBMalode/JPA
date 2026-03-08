package com.xworkz.studentPortal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentDTO {

    private int id;
    private int age;
    private String email;
    private Long contactNumber;
    private String name;
    private String cllgName;
    private String location;

}
