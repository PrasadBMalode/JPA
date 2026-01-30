package com.xworkz.acer.external;

import com.xworkz.acer.entity.AcerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AcerRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Acer");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        AcerEntity acerEntity = new AcerEntity(9, "Ravi", "Mangalore");

        entityManager.persist(acerEntity);
        System.out.println("row inserted...");


        AcerEntity data=entityManager.find(AcerEntity.class,8);
        System.out.println(data.toString());
        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();




    }
}
