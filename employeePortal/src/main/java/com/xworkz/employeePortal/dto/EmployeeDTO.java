package com.xworkz.employeePortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private int age;
    private String name;
    private String companyName;
    private String phNumber;

}
