package com.xworkz.xworkz_Prasad_Modules.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "otp_table")
@Data

public class OtpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    private String otp;
    private long expiryTime;
    private int attempts;

}
