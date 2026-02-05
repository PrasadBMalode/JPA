package com.xworkz.namedQuery.external;

import javax.persistence.*;
import java.util.List;

public class FindByAgeGraterThan18 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query=em.createNamedQuery("findByAgeGreaterThan18");
        List list = query.getResultList();
        list.forEach(n-> System.out.println(n));

        em.close();
        emf.close();

    }
}
