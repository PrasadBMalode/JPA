package com.xworkz.jpaConnection.external;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Connection_1Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaConnection_1");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        if (entityManagerFactory != null) {
            System.out.println("DataBase connected succesfully...!");

        } else {
            System.out.println("DataBase not connected...!");
        }

    }
}
