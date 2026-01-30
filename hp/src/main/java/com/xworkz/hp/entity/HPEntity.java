package com.xworkz.hp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "laptop_tb")
public class HPEntity {

    @Id
    private int laptopID;
    private String customerName;
    private String location;

}
