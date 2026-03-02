package com.xworkz.trip.dao;

import com.xworkz.trip.entity.TripEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class TripDAOImpl implements TripDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean saveDB(TripEntity tripEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            entityManager.persist(tripEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            entityManager.close();

        }


    }

    @Override
    public List<TripEntity> readFromDB() {


        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {

            Query namedQuery = entityManager.createNamedQuery("readData");
            List<TripEntity> resultList = (List<TripEntity>) namedQuery.getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();

        }
        return Collections.emptyList();
    }

    @Override
    public TripEntity findByStudentEmail(String email) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("byEmail",email);
            TripEntity singleResult = (TripEntity) query.getSingleResult();
            return singleResult;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            entityManager.close();
        }

    }

    @Override
    public TripEntity findByStudentNumber(String contactNumber) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByNumber");
            query.setParameter("byNumber",contactNumber);
            TripEntity singleResult = (TripEntity) query.getSingleResult();
            return singleResult;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }

    @Override
    public TripEntity findStudentByID(Integer id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            TripEntity tripEntity = entityManager.find(TripEntity.class, id);
            return tripEntity;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }
}
