package com.xworkz.studentDetailsUpdate.external;

import com.xworkz.studentDetailsUpdate.entity.StudentDetailsUpdateEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDetailsUpdateRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        StudentDetailsUpdateEntity updateData7 = em.find(StudentDetailsUpdateEntity.class, 7);
        updateData7.setStudentName("Poornima");
        updateData7.setStudentAge(28);
        em.merge(updateData7);

        StudentDetailsUpdateEntity updateData8 = em.find(StudentDetailsUpdateEntity.class, 8);
        updateData8.setStudentName("Savita");
        em.merge(updateData8);

        StudentDetailsUpdateEntity updateData11 = em.find(StudentDetailsUpdateEntity.class, 11);
        updateData11.setStudentName("Taslim");
        em.merge(updateData11);

        StudentDetailsUpdateEntity updateData1 = em.find(StudentDetailsUpdateEntity.class, 1);
        updateData1.setStudentName("Sai Prasad");
        updateData1.setStudentAge(23);
        em.merge(updateData1);


        System.out.println("row updated...");
        et.commit();
        em.close();
        emf.close();
    }
}
