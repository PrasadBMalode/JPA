package com.xworkz.studentPortal.dao;

import com.xworkz.studentPortal.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean save(StudentEntity studentEntity) {
        System.out.println("entity in repo="+studentEntity);
        System.out.println(entityManagerFactory);
        EntityManager entityManager=null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(studentEntity);
            transaction.commit();
            return true;
        }catch (Exception exception){
            System.out.println(exception.getMessage());
            return false;
        }finally {
            entityManager.close();

        }
    }

    @Override
    public List<StudentEntity> getTraineeData() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readALL");
            List<StudentEntity> entities =(List<StudentEntity>) query.getResultList();
            System.out.println(entities);
            return  entities;
        }catch (Exception exception){
            return Collections.emptyList();
        }finally {
            entityManager.close();
        }
    }

    @Override
    public StudentEntity getTraineeBasedOnEmail(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByEmail");
            query.setParameter("traineeEmail",email);
            StudentEntity studentEntity =(StudentEntity) query.getSingleResult();
            return studentEntity;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }

    @Override
    public StudentEntity getTraineeBasedOnId(int id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
            return studentEntity;
        }catch (Exception e){
            System.out.println("exception in reading data based on id=="+e.getMessage());
            return null;
        }finally {
            entityManager.close();
        }

    }

    @Override
    public void uodateTrainee(StudentEntity studentEntity) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(studentEntity);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(String email) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try{
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("deleteTrainee");
            query.setParameter("traineeEmail",email);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e){

            System.out.println(e.getMessage());
        }finally {
            entityManager.close();
        }
    }
}
