package com.xworkz.asus.external;

import com.xworkz.asus.entity.AsusEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AsusRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asus");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();

        AsusEntity asusEntity=new AsusEntity(8,"Dhanveer","Ranebennur");

        entityManager.persist(asusEntity);
        System.out.println("row inserted...");

        AsusEntity asus=entityManager.find(AsusEntity.class,6);
        System.out.println(asus.toString());

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
