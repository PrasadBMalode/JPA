package com.xworkz.studentGetDetails.entity;

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
@Table(name = "student_tb")
public class StudentGetDetailsEntity {

    @Id
    private int studentId;
    private String studentName;
    private int studentAge;
    private long phNumber;
}
