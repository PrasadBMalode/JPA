package com.xworkz.studentDetails.external;

import com.xworkz.studentDetails.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        //StudentEntity studentEntity = new StudentEntity(1, "Prasad", 24, 6360211265l);
        //StudentEntity studentEntity = new StudentEntity(2, "Dayananda", 24, 87456973653l);
        //StudentEntity studentEntity = new StudentEntity(3, "Sharath", 24, 7834223984l);
        //StudentEntity studentEntity = new StudentEntity(4, "Kumar", 24, 885466653l);
        //StudentEntity studentEntity = new StudentEntity(5, "Pavan", 24, 9996743523l);
        //StudentEntity studentEntity = new StudentEntity(6, "Anita", 24, 9123456789L);
        //StudentEntity studentEntity = new StudentEntity(7, "Priya", 24, 9988776655L);
       // StudentEntity studentEntity = new StudentEntity(8, "Suresh", 24, 9012345678L);
        //StudentEntity studentEntity = new StudentEntity(9, "Neha", 24, 8899776655L);
        StudentEntity studentEntity = new StudentEntity(10, "Amit", 24, 9345678901L);

        em.persist(studentEntity);
        System.out.println("row inserted...");
        et.commit();

        em.close();
        emf.close();
    }
}
