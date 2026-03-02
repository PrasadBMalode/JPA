package com.xworkz.trip.service;

import com.xworkz.trip.dao.TripDAO;
import com.xworkz.trip.dto.TripDTO;
import com.xworkz.trip.entity.TripEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    TripDAO tripDAO;

    @Override
    public String studetValidation(TripDTO tripDTO) {

        if (tripDTO.getAge() != null && tripDTO.getAge() > 13 &&
                tripDTO.getName() != null && tripDTO.getName().length() >= 4 &&
                tripDTO.getCllgName() != null && tripDTO.getCllgName().length() > 5 &&
                tripDTO.getLocation() != null && tripDTO.getLocation().length() >= 3 &&
                tripDTO.getGender() != null && !tripDTO.getGender().isEmpty() &&
                tripDTO.getClassName() != null &&
                tripDTO.getEmail() != null && tripDTO.getEmail().contains("@gmail.com") &&
                tripDTO.getContactNumber() != null && tripDTO.getContactNumber().length() == 10) {


            TripDTO tripDTO1 = findByEmailValidation(tripDTO.getEmail());
            TripDTO tripDTO2 = findByContactNumberValidation(tripDTO.getContactNumber());
            if (tripDTO1 == null && tripDTO2 == null) {
                TripEntity tripEntity = new TripEntity();
                BeanUtils.copyProperties(tripDTO, tripEntity);
                if (tripDAO.saveDB(tripEntity)) {
                    return "Register Successfully done";
                } else {
                    return "Register failed in DB...!";
                }
            } else {
                return "Data alredy exist either Email or Contact number...!";
            }
        } else {
            return "Not registered, Enter valid Data...!";
        }
    }

    @Override
    public List<TripDTO> readAllData() {

        List<TripEntity> tripEntities = tripDAO.readFromDB();
        if (!tripEntities.isEmpty()) {

            List<TripDTO> tripDTOS = new ArrayList<>();

            tripEntities.forEach(tripEntity -> {

                TripDTO tripDTO = new TripDTO();
                BeanUtils.copyProperties(tripEntity, tripDTO);

                tripDTOS.add(tripDTO);
            });
            return tripDTOS;
        } else {
            return Collections.emptyList();
        }


    }

    @Override
    public TripDTO findByEmailValidation(String email) {

        TripEntity tripEntity = tripDAO.findByStudentEmail(email);
        if (tripEntity != null) {
            TripDTO tripDTO = new TripDTO();
            BeanUtils.copyProperties(tripEntity, tripDTO);
            return tripDTO;
        }
        return null;
    }

    @Override
    public TripDTO findByContactNumberValidation(String contactNumber) {

        TripEntity tripEntity = tripDAO.findByStudentNumber(contactNumber);
        if (tripEntity != null) {

            TripDTO tripDTO = new TripDTO();
            BeanUtils.copyProperties(tripEntity, tripDTO);
            return tripDTO;
        }
        return null;
    }

    @Override
    public TripDTO getStudentByID(Integer id) {
        TripEntity tripEntity = tripDAO.findStudentByID(id);
        if (id != 0) {
            TripDTO tripDTO = new TripDTO();
            BeanUtils.copyProperties(tripEntity, tripDTO);
            return tripDTO;
        }
        return null;
    }
}
