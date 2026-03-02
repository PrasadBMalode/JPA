package com.xworkz.trip.service;

import com.xworkz.trip.dto.TripDTO;

import java.util.List;

public interface TripService {

    String studetValidation(TripDTO tripDTO);

    List<TripDTO> readAllData();

    TripDTO findByEmailValidation(String email);

    TripDTO findByContactNumberValidation(String contactNumber);

    TripDTO getStudentByID(Integer id);
}
