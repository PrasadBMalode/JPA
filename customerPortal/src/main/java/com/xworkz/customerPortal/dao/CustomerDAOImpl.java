package com.xworkz.customerPortal.dao;

import com.xworkz.customerPortal.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Override
    public void saveDB(CustomerEntity customerEntity) {
        System.out.println("DataBase===" + customerEntity);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("customer");
        EntityManager entityManager = null;

        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            entityManager.persist(customerEntity);
            entityTransaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            entityManagerFactory.close();
            entityManager.close();

        }


    }
}
