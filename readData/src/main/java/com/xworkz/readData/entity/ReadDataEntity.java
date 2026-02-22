package com.xworkz.readData.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "travaler_tb")
@NamedQuery(name = "readAllData", query = "select re from ReadDataEntity re")
public class ReadDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String name;
    private String location;
    private Long number;
}
