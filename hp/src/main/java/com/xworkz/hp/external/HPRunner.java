package com.xworkz.hp.external;

import com.xworkz.hp.entity.HPEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HPRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("hp");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();

        HPEntity hpEntity=new HPEntity(7,"Varun","Haveri");

        entityManager.persist(hpEntity);
        System.out.println("row inserted...");

        HPEntity data=entityManager.find(HPEntity.class,5);
        System.out.println(data.toString());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
