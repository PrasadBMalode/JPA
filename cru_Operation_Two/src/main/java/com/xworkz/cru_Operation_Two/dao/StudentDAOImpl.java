package com.xworkz.cru_Operation_Two.dao;

import com.xworkz.cru_Operation_Two.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @Override
    public boolean studentDetailsSaveToDB(StudentEntity studentEntity) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.persist(studentEntity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public StudentEntity fetchingStudentdetailsFromDB(Long contactNumber) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("findByNumber");
            query.setParameter("byNumber",contactNumber);
            StudentEntity singleResult =(StudentEntity) query.getSingleResult();
            return singleResult;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    @Override
    public List<StudentEntity> fetchingAllStudentaDataFromDB() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            Query query = entityManager.createNamedQuery("readAllStudents");
            List<StudentEntity> resultList = (List<StudentEntity>) query.getResultList();
            return resultList;

        }catch (Exception e){
            System.out.println(e.getMessage());
            return Collections.emptyList();
        }finally {
            entityManager.close();

        }

    }

    @Override
    public StudentEntity updatingStudentDataToDB(Integer id) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
            return studentEntity;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }

    }
}
