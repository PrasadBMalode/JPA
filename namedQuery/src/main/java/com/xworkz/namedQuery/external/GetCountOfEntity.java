package com.xworkz.namedQuery.external;

import javax.persistence.*;

public class GetCountOfEntity {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

       Query query= em.createNamedQuery("getCountOfEntity");
        //Object singleResult = query.getSingleResult();
        Long singleResult=(Long) query.getSingleResult();
        System.out.println(singleResult);

        em.close();
        emf.close();


    }
}
