package com.xworkz.cru_Operation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private Integer id;
    private Integer age;
    private String name;
    private String email;
    private String gender;
    private Long contactNumber;
}
