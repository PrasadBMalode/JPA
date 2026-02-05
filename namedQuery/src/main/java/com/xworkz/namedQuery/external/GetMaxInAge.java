package com.xworkz.namedQuery.external;

import javax.persistence.*;

public class GetMaxInAge {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

       Query query=em.createNamedQuery("getMaxInAge");
       Integer result=(Integer) query.getSingleResult();
        System.out.println(result);

        em.close();
        emf.close();



    }
}
