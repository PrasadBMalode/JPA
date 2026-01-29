package com.xworkz.jpaConnection_2.external;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPAConnection_2Runner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpaConnection_2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        if (entityManagerFactory!=null){
            System.out.println("DB connected...");
        }else {
            System.out.println("DB not connected..");
        }
    }
}
