package com.xworkz.getData.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDataDTO {

    private Integer age;
    private String name;
    private String location;
    private Long number;
}
