package com.xworkz.namedQuery.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "query_tb")
@Data
@AllArgsConstructor
@NoArgsConstructor

@NamedQuery(name = "findByName",
        query = "select nq from NamedQueryEntity nq where nq.name =:nameby ")

@NamedQuery(name = "findByPhNumber",
        query = "select nq from NamedQueryEntity nq where nq.phNumber =:phNumberby")

@NamedQuery(name = "findByEmail",
        query = "select nq from NamedQueryEntity nq where nq.email =:emailby")

@NamedQuery(name = "findByPhNoAndEmail",
        query = "select nq from NamedQueryEntity nq where nq.phNumber =:phNumberby and nq.email =:emailby")

@NamedQuery(name = "findByAgeGreaterThan18",
        query = "SELECT nq FROM NamedQueryEntity nq WHERE nq.age > 18")

@NamedQuery(name = "getCountOfEntity",
        query ="select count(nq) from NamedQueryEntity nq")

@NamedQuery(name = "getMaxInAge",
        query = "select MAX(nq.age) from NamedQueryEntity nq")

@NamedQuery(name = "getMinInAge",
        query = "select MIN(nq.age) from NamedQueryEntity nq")

@NamedQuery(name = "getAllNameList",
        query = "select nq.name from NamedQueryEntity nq")



public class NamedQueryEntity {

    @Id
    private int id;
    private String name;
    private long phNumber;
    private int age;
    private String email;
}
