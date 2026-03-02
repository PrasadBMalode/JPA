package com.xworkz.cru_Operation.dao;

import com.xworkz.cru_Operation.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean userDetailsSaveToDb(UserEntity userEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(userEntity);
            transaction.commit();
            return true;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return false;
        } finally {
            entityManager.close();
        }


    }

    @Override
    public UserEntity getExistUserByEmail(String email) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("byEmail", email);
            UserEntity singleResult = (UserEntity) query.getSingleResult();
            return singleResult;
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public List<UserEntity> getAllUsersListfromDB() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            Query query = entityManager.createNamedQuery("fetchAllUsers");
            List<UserEntity> resultList = (List<UserEntity>) query.getResultList();
            return resultList;

        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public UserEntity getingUserToUpdateDataFromDBByID(Integer id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            UserEntity userEntity = entityManager.find(UserEntity.class, id);
            return userEntity;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
