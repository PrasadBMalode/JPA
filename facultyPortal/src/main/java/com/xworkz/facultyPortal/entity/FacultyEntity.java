package com.xworkz.facultyPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "fac_tb")
@AllArgsConstructor
@NoArgsConstructor
public class FacultyEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String name;
    private String cllgName;
    private String phNumber;
}
