package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.OtpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

@Repository
public class OtpDAOImpl implements OtpDAO {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public void saveOtp(OtpEntity otpEntity) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // If OTP already exists → update
            Query query = em.createQuery("SELECT o FROM OtpEntity o WHERE o.email=:email");
            query.setParameter("email", otpEntity.getEmail());

            OtpEntity existing = null;
            try {
                existing = (OtpEntity) query.getSingleResult();
            } catch (Exception ignored) {}

            if (existing != null) {
                existing.setOtp(otpEntity.getOtp());
                existing.setExpiryTime(otpEntity.getExpiryTime());
                existing.setAttempts(0);
                em.merge(existing);
            } else {
                em.persist(otpEntity);
            }

            tx.commit();
        } finally {
            em.close();
        }
    }

    @Override
    public OtpEntity findByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT o FROM OtpEntity o WHERE o.email=:email");
            query.setParameter("email", email);
            return (OtpEntity) query.getSingleResult();
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Query query = em.createQuery("DELETE FROM OtpEntity o WHERE o.email=:email");
            query.setParameter("email", email);
            query.executeUpdate();
            tx.commit();
        } finally {
            em.close();
        }
    }
}
