package com.xworkz.crud_Operation.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.crud_Operation.entity.UserEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveDB(UserEntity userEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(userEntity);
            transaction.commit();
            return true;
        }catch (Exception e){
            System.out.println("Exception in /saveDB/ method"+e.getMessage());
            return false;
        }
    }

    @Override
    public UserEntity checkingExistUserDataInDB(Long phNumber) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            Query query = entityManager.createNamedQuery("findByPhNumber");
            query.setParameter("byPhNumber",phNumber);
            UserEntity singleResult = (UserEntity) query.getSingleResult();
            return singleResult;
        }catch (Exception e){
            System.out.println("Exception in /checkingExistUserDataInDB/ method, Means new user Registered..."+e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }

    @Override
    public List<UserEntity> readAllDataFromDB() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readAllData");
            List<UserEntity> resultList =(List<UserEntity>) query.getResultList();
            return resultList;
        }catch (Exception e){
            System.out.println("Exception in /readAllDataFromDB/ methos"+e.getMessage());
            return Collections.emptyList();
        }finally {
            entityManager.close();
        }

    }

    @Override
    public UserEntity fetchingDtoFromDB(Integer id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            UserEntity userEntity = entityManager.find(UserEntity.class, id);
            return userEntity;
        }catch (Exception e){
            System.out.println("Exception in /fetchingDtoFromDB/ method"+e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }

    @Override
    public void updatedDataSaveDB(UserEntity userEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(userEntity);
            transaction.commit();
        }catch (Exception e){
            System.out.println("Exception in /updatedDataSaveDB/ method"+e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void deletingUserDataInDB(Long phNumber) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("deletData");
            query.setParameter("byPhNumber",phNumber);
            query.executeUpdate();
            transaction.commit();

        }catch (Exception e){
            System.out.println("Exception in /deletingUserDataInDB/ method"+e.getMessage());
        }
    }
}
