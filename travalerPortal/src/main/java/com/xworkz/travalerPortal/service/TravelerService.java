package com.xworkz.travalerPortal.service;

import com.xworkz.travalerPortal.dto.TravalerDTO;

import java.util.List;

public interface TravelerService {

    boolean registerValidation(TravalerDTO travalerDTO);

    List<TravalerDTO> readAllData();


}
