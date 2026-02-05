package com.xworkz.namedQuery.external;

import com.xworkz.namedQuery.entity.NamedQueryEntity;

import javax.persistence.*;

public class FindByPhNoAndEmail {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query = em.createNamedQuery("findByPhNoAndEmail");

        query.setParameter("phNumberby", 6666666666l);
        query.setParameter("emailby", "raksha123@gmail.com");

        Object entity = query.getSingleResult();

        System.out.println(entity);

        em.close();
        emf.close();
    }
}
