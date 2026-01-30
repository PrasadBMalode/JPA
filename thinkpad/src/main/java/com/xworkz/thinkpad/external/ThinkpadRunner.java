package com.xworkz.thinkpad.external;

import com.xworkz.thinkpad.entity.ThinkpadEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class ThinkpadRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("thinkpad");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        ThinkpadEntity thinkpadEntity = new ThinkpadEntity(5, "Ravi", "Mysore");

        entityManager.persist(thinkpadEntity);
        System.out.println("row inserted...");

        ThinkpadEntity data = entityManager.find(ThinkpadEntity.class, 3);
        System.out.println(data.toString());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
