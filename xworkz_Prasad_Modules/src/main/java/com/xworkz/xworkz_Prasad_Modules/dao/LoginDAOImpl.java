package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class LoginDAOImpl implements LoginDAO{

    @Autowired
    EntityManagerFactory entityManagerFactory;

//    @Override
//    public String loginDataCheckInDB(String email) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        String passwordFromDB = null;
//
//        try {
//            EntityTransaction transaction = entityManager.getTransaction();
//            transaction.begin();
//            Query query = entityManager.createNamedQuery("findByLogin");
//            query.setParameter("byEmail",email);
//
//            passwordFromDB =(String) query.getSingleResult();
//            return passwordFromDB;
//
//        }catch (Exception e){
//            System.out.println("Error in 'loginDataCheckInDB' method "+e.getMessage());
//            return null;
//        }finally {
//            entityManager.close();
//        }
//    }

    public UserEntity findByEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("byEmail", email);
            UserEntity singleResult =(UserEntity) query.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    public void updateUser(UserEntity user) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(user);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            entityManager.close();
        }
    }


}
