package com.xworkz.rapido.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rapido_tb")
@NamedQuery(name = "fetchingAllData",query = "select nq from DriverEntity nq")
@NamedQuery(name = "findByEmail",query = "select nq from DriverEntity nq where nq.email=:byEmail")
@NamedQuery(name = "deletingData",query = "delete from DriverEntity nq where nq.email=:byEmailDeleting")
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String vehical;
    private String email;
    private Long contactNumber;
}
