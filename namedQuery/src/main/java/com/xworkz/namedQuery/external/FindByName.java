package com.xworkz.namedQuery.external;

import javax.persistence.*;

public class FindByName {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createNamedQuery("findByName");
        query.setParameter("nameby", "prasad");
        Object singleResult = query.getSingleResult();
        System.out.println(singleResult);

        em.close();
        emf.close();
    }
}
