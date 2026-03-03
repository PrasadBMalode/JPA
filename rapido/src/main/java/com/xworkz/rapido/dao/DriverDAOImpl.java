package com.xworkz.rapido.dao;

import com.xworkz.rapido.entity.DriverEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class DriverDAOImpl implements DriverDAO{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveingToDB(DriverEntity driverEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(driverEntity);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            entityManager.close();
        }


    }

    @Override
    public DriverEntity findingExistDriverInDBByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("byEmail",email);
            DriverEntity singleResult =(DriverEntity) query.getSingleResult();
            return singleResult;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }

    @Override
    public List<DriverEntity> fetchingAllDataFromDB() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("fetchingAllData");
            List<DriverEntity> resultList =(List<DriverEntity>) query.getResultList();
            return resultList;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }finally {
            entityManager.close();
        }

    }

    @Override
    public DriverEntity findAndFetchDriverFromDB(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            DriverEntity driverEntity = entityManager.find(DriverEntity.class, id);
            return driverEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
