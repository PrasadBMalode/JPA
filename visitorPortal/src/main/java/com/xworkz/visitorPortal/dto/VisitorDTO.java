package com.xworkz.visitorPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDTO {
    private Integer age;
    private String name;
    private String location;
    private Long number;
}
