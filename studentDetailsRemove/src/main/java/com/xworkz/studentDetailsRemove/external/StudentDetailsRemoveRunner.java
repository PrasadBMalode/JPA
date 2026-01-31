package com.xworkz.studentDetailsRemove.external;

import com.xworkz.studentDetailsRemove.entity.StudentDetailsRemoveEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDetailsRemoveRunner {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();


        StudentDetailsRemoveEntity removeRow2 = entityManager.find(StudentDetailsRemoveEntity.class, 2);
        //entityManager.remove(removeRow2);

        StudentDetailsRemoveEntity removeRow4 = entityManager.find(StudentDetailsRemoveEntity.class, 4);
        //entityManager.remove(removeRow4);

        StudentDetailsRemoveEntity removeRow6 = entityManager.find(StudentDetailsRemoveEntity.class, 6);
        //entityManager.remove(removeRow6);

        StudentDetailsRemoveEntity removeRow8 = entityManager.find(StudentDetailsRemoveEntity.class, 8);
        //entityManager.remove(removeRow8);

        StudentDetailsRemoveEntity removeRow10 = entityManager.find(StudentDetailsRemoveEntity.class, 10);
        entityManager.remove(removeRow10);

        entityTransaction.commit();
    }
}
