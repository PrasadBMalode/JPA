package com.xworkz.visitorPortal.dao;

import com.xworkz.visitorPortal.entity.VisitorEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

@Repository
public class VisitorDAOImpl implements VisitorDAO {
    @Override
    public void saveDB(VisitorEntity visitorEntity) {

        System.out.println("repository==="+visitorEntity);

        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("visitor");
        EntityManager entityManager=null;
        try {
            entityManager=entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(visitorEntity);
            transaction.commit();
//            return true;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManagerFactory.close();
            entityManager.close();
        }

    }
}
