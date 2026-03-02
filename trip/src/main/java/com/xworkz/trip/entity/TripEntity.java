package com.xworkz.trip.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trip_tb")
@NamedQuery(name = "readData",query = "select re from TripEntity re")
@NamedQuery(name = "findByEmail",query = "select nq from TripEntity nq where nq.email=:byEmail")
@NamedQuery(name = "findByNumber",query = "select n from TripEntity n where n.contactNumber=:byNumber")

public class TripEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String name;
    private String cllgName;
    private String location;
    private String gender;
    private String className;
    private String email;
    private String contactNumber;
}
