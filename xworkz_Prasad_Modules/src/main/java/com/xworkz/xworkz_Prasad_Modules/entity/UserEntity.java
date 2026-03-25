package com.xworkz.xworkz_Prasad_Modules.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prasadModules_tb")
@NamedQuery(name = "findByEmail",query = "select nq from UserEntity nq where nq.email=:byEmail")
@NamedQuery(name = "findByLogin",query = "select nq.password from UserEntity nq where nq.email = :byEmail")
@NamedQuery(name = "readALlUsers",query = "select nq from UserEntity nq")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private LocalDate dob;
    private Integer age;
    private String gender;
    private String location;
    private String email;
    private Long phNumber;
    private String password;
    private Integer loginAttempts;
    private Boolean accountLocked=false;

}
