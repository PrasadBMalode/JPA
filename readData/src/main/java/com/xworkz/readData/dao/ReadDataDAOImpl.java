package com.xworkz.readData.dao;

import com.xworkz.readData.entity.ReadDataEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Collections;
import java.util.List;

@Repository
public class ReadDataDAOImpl implements ReadDataDAO{
    @Override
    public List<ReadDataEntity> readDB() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("travaler");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Query namedQuery = entityManager.createNamedQuery("readAllData");
            List<ReadDataEntity> resultList = (List<ReadDataEntity>) namedQuery.getResultList();
            return resultList;

        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }


        return Collections.emptyList();
    }
}
