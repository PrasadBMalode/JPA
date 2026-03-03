package com.xworkz.rapido.service;

import com.xworkz.rapido.dto.DriverDTO;

import java.util.List;

public interface DriverService {

    String registrationValidationForSaveToDB(DriverDTO driverDTO);

    DriverDTO findingExistDriverValidationByEmail(String email);

    List<DriverDTO> fetchingDataValidation();

    DriverDTO findAndFetchDriverValidation(Integer id);
}
