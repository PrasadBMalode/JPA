package com.xworkz.customerPortal.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor

public class CustomerPortalDTO {

    private Integer customerAge;
    private String customerName;
    private String customerLocation;
    private String customerReview;
    private Long customerNumber;

}
