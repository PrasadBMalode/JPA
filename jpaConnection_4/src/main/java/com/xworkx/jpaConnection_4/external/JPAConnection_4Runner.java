package com.xworkx.jpaConnection_4.external;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAConnection_4Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaConnection_4");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();

        if (entityManagerFactory!=null){
            System.out.println("DB connected...!");
        }else {
            System.out.println("DB not connected...");
        }

    }
}
