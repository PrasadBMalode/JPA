package com.xworkz.rapido.dao;

import com.xworkz.rapido.entity.DriverEntity;

import java.util.List;

public interface DriverDAO {

    boolean saveingToDB(DriverEntity driverEntity);

    DriverEntity findingExistDriverInDBByEmail(String email);

    List<DriverEntity> fetchingAllDataFromDB();

    DriverEntity findAndFetchDriverFromDB(Integer id);

    void updatingDriverDetailsInDB(DriverEntity driverEntity);

    void DeletingDataFromDB(String email);
}
