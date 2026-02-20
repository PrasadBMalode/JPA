package com.xworkz.getData.dao;

import com.xworkz.getData.entity.GetDataEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class GetDataDAOImpl implements GetDataDAO {
    @Override
    public List<GetDataEntity> getDBData() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("travaler");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            Query query = entityManager.createNamedQuery("readAllData");
            List<GetDataEntity> resultList = (List<GetDataEntity>) query.getResultList();
            System.out.println("repository==="+resultList);
            return resultList;
        } catch (Exception exception) {
            exception.printStackTrace();
            return Collections.emptyList();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
