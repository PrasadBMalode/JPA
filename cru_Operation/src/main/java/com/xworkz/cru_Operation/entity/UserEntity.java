package com.xworkz.cru_Operation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_tb")
@NamedQuery(name = "findByEmail", query = "select nq from UserEntity nq where nq.email=:byEmail")
@NamedQuery(name = "fetchAllUsers",query = "select nq from UserEntity nq")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String name;
    private String email;
    private String gender;
    private Long contactNumber;
}
