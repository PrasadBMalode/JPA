package com.xworkz.trip.dao;

import com.xworkz.trip.entity.TripEntity;

import java.util.List;

public interface TripDAO {
    boolean saveDB(TripEntity tripEntity);

    List<TripEntity> readFromDB();

    TripEntity findByStudentEmail(String email);

    TripEntity findByStudentNumber(String contactNumber);

    TripEntity findStudentByID(Integer id);
}
