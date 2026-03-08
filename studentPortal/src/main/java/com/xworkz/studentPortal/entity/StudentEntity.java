package com.xworkz.studentPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "std_tb")
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "deleteTrainee",query = "delete from StudentEntity entity where entity.email=:traineeEmail")
@NamedQuery(name="readALL",query = "select e from StudentEntity e")
@NamedQuery(name="findByEmail",query = "select entity from StudentEntity entity where entity.email=:traineeEmail")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int age;
    private String email;
    private Long contactNumber;
    private String name;
    private String cllgName;
    private String location;
}
