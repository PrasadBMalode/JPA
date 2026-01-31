package com.xworkz.studentGetDetails.external;

import com.xworkz.studentGetDetails.entity.StudentGetDetailsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentGetDetailsRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();


        StudentGetDetailsEntity data1 = em.find(StudentGetDetailsEntity.class, 1);
        StudentGetDetailsEntity data3 = em.find(StudentGetDetailsEntity.class, 3);
        StudentGetDetailsEntity data4 = em.find(StudentGetDetailsEntity.class, 4);
        StudentGetDetailsEntity data6 = em.find(StudentGetDetailsEntity.class, 6);
        StudentGetDetailsEntity data11 = em.find(StudentGetDetailsEntity.class, 11);
        
        System.out.println(data1.toString());
        System.out.println(data3.toString());
        System.out.println(data4.toString());
        System.out.println(data6.toString());
        System.out.println(data11.toString());

        em.close();
        emf.close();
    }
}
