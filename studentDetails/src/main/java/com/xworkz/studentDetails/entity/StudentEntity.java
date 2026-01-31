package com.xworkz.studentDetails.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@Table(name = "student_tb")
public class StudentEntity {
    @Id
    private int studentId;
    private String studentName;
    private int studentAge;
    private long phNumber;

}
