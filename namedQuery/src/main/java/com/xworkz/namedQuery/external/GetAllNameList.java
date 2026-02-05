package com.xworkz.namedQuery.external;

import javax.persistence.*;
import java.util.List;

public class GetAllNameList {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NamedQuery");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Query query=em.createNamedQuery("getAllNameList");

        List<String> namesList=query.getResultList();
        namesList.forEach(n-> System.out.println(n));
        //System.out.println(namesList);
    }
}
