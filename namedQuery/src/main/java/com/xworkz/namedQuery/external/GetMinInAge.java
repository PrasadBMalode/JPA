package com.xworkz.namedQuery.external;

import javax.persistence.*;

public class GetMinInAge {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createNamedQuery("getMinInAge");
        Integer result=(Integer) query.getSingleResult();
        System.out.println(result);

        em.close();
        emf.close();
    }
}
