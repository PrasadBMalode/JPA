package com.xworkz.travalerPortal.dao;

import com.xworkz.travalerPortal.entity.TravalerEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

import java.util.List;

@Repository
public class TravalerDAOImpl implements TravalerDAO {


    @Override
    public void saveDB(TravalerEntity travalerEntity) {

        System.out.println("Repository===" + travalerEntity);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("travaler");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(travalerEntity);
            transaction.commit();

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }


    }

    @Override
    public List<TravalerEntity> readPassangerData() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("travaler");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readAllData");
            List<TravalerEntity> resultList = (List<TravalerEntity>) query.getResultList();
            System.out.println("repository==="+resultList);
            return resultList;

        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

        return null;
    }
}
