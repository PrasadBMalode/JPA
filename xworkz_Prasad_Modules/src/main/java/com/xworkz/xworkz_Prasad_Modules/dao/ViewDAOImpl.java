package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class ViewDAOImpl implements ViewDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public UserEntity readUserDataToUpdate(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("byEmail", email);
            UserEntity singleResult = (UserEntity) query.getSingleResult();
            transaction.commit();
            return singleResult;

        } catch (Exception e) {
            System.out.println("errorn in 'readUserDataToUpdate' method" + e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean updatingExistUserDataInDB(UserEntity userEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.merge(userEntity);

            transaction.commit();
            return true;

        } catch (Exception e) {

            System.out.println("error in updatingExistUserDataInDB " + e.getMessage());
            return false;

        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<UserEntity> readAllUsersFromDB() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readALlUsers");
            List<UserEntity> resultList = (List<UserEntity>) query.getResultList();
            return resultList;
        }catch (Exception e){
            System.out.println("error in 'readAllUsersFromDB' method"+e.getMessage());
            return Collections.emptyList();
        }finally {
            entityManager.close();
        }

    }
}