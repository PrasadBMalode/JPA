package com.xworkz.crud_Operation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "userInfo_tb")
@NamedQuery(name = "findByPhNumber",query = "select nq from UserEntity nq where nq.phNumber=:byPhNumber")
@NamedQuery(name = "readAllData",query = "select nq from UserEntity nq")
@NamedQuery(name = "deletData",query = "delete from UserEntity nq where nq.phNumber=:byPhNumber")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String name;
    private String location;
    private Long phNumber;
}
