package com.xworkz.crud_Operation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private Integer id;
    private Integer age;
    private String name;
    private String location;
    private Long phNumber;
}
