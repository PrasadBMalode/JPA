package com.xworkz.cru_Operation_Two.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cru_tb")
@NamedQuery(name = "findByNumber", query = "select nq from StudentEntity nq where nq.contactNumber=:byNumber")
@NamedQuery(name = "readAllStudents", query = "select nq from StudentEntity nq")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String name;
    private String cllgName;
    private Long contactNumber;
}
