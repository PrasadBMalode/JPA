package com.xworkz.cru_Operation_Two.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    private Integer id;
    private Integer age;
    private String name;
    private String cllgName;
    private Long contactNumber;
}
