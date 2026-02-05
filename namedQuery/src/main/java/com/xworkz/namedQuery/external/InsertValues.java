package com.xworkz.namedQuery.external;

import com.xworkz.namedQuery.entity.NamedQueryEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InsertValues {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        et.begin();

        List<NamedQueryEntity> list= new ArrayList();
        list.add(new NamedQueryEntity(1,"Prasad",9999999999l,20,"prasad123@gmail.com"));
        list.add(new NamedQueryEntity(2,"Hema",8888888888l,21,"prasad123@gmail.com"));
        list.add(new NamedQueryEntity(3,"Priyanka",7777777777l,22,"priyanka123@gmail.com"));
        list.add(new NamedQueryEntity(4,"Raksha",6666666666l,23,"raksha123@gmail.com"));
        list.add(new NamedQueryEntity(5,"Taslim",5555555555l,24,"taslim123@gmail.com"));
        list.add(new NamedQueryEntity(6,"Prerana",4444444444l,25,"prerana123@gmail.com"));
        for (NamedQueryEntity data:list)
        em.persist(data);

        et.commit();

        em.close();
        emf.close();
    }
}
