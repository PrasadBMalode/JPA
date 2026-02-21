package com.xworkz.travalerPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travaler_tb")
@NamedQuery(name = "readAllData", query = "select te from TravalerEntity te")

public class TravalerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String name;
    private String location;
    private Long number;
}
