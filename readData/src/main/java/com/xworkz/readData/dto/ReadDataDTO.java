package com.xworkz.readData.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReadDataDTO {

    private Integer age;
    private String name;
    private String location;
    private Long number;
}
