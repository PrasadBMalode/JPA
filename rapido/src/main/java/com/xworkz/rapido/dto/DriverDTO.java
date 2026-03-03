package com.xworkz.rapido.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverDTO {

    private Integer id;
    private String name;
    private Integer age;
    private String vehical;
    private String email;
    private Long contactNumber;
}
