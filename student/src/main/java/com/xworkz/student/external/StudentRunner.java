package com.xworkz.student.external;

import com.xworkz.student.entity.StudentEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class StudentRunner {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

//        <insert to DB>

//        List<StudentEntity> list = new ArrayList();
//        list.add(new StudentEntity(102, "lavanya", 20, 7774532476l));
//        list.add(new StudentEntity(103, "Pramila", 20, 999996546l));
//        for (StudentEntity data : list) {
//            em.persist(data);
//        }


//        <Get from DB>

        StudentEntity data=em.find(StudentEntity.class,1);
        System.out.println(data.toString());

//        <Update to DB>

//        data.setStudentName("Rony");
//        em.merge(data);


//        <Delete from DB>
        em.remove(data);
        et.commit();


        em.close();
        emf.close();

    }
}
