package com.xworkz.lenovo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "laptop_tb")
public class LenovoEntity {

    @Id
    private int laptopID;
    private String customerName;
    private String location;
}
