package com.xworkz.lenovo.external;

import com.xworkz.lenovo.entity.LenovoEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LenovoRunner {
    public static void main(String[] args) {
        EntityManagerFactory lenovo = Persistence.createEntityManagerFactory("Lenovo");
        EntityManager entityManager = lenovo.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        LenovoEntity lenovoEntity=new LenovoEntity(18,"Santhosh","Ranebennur");

        entityManager.persist(lenovoEntity);
        System.out.println("row inserted...");
        transaction.commit();



    }
}
