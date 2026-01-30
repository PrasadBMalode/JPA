package com.xworkz.dell.external;

import com.xworkz.dell.entity.DellEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DellRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dell");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        DellEntity dellEntity = new DellEntity(4, "pavan", "Bangalore");

        entityManager.persist(dellEntity);
        System.out.println("inserted row...");


        DellEntity data = entityManager.find(DellEntity.class, 1);
        System.out.println(data.toString());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
