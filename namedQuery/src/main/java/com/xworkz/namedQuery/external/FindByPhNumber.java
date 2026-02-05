package com.xworkz.namedQuery.external;

import javax.persistence.*;

public class FindByPhNumber {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createNamedQuery("findByPhNumber");
        query.setParameter("phNumberby", 8888888888l);
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);

        em.close();
        emf.close();


    }
}
