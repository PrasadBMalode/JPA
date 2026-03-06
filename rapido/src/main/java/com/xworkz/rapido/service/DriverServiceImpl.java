package com.xworkz.rapido.service;

import com.xworkz.rapido.dao.DriverDAO;
import com.xworkz.rapido.dto.DriverDTO;
import com.xworkz.rapido.entity.DriverEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    DriverDAO driverDAO;

    @Override
    public String registrationValidationForSaveToDB(DriverDTO driverDTO) {

        if (driverDTO.getAge() != null && driverDTO.getAge() > 18 && driverDTO.getAge() < 100 &&

                driverDTO.getName() != null && !driverDTO.getName().trim().isEmpty() && driverDTO.getName().length() >= 4 && driverDTO.getName().matches("[a-zA-Z ]+") &&

                driverDTO.getVehical() != null && !driverDTO.getVehical().trim().isEmpty() && driverDTO.getVehical().length() >= 2 &&

                driverDTO.getEmail() != null && !driverDTO.getEmail().trim().isEmpty() && driverDTO.getEmail().contains("@") && driverDTO.getEmail().contains(".") &&

                driverDTO.getContactNumber() != null && String.valueOf(driverDTO.getContactNumber()).length() == 10) {

            DriverDTO driverDTO1 = findingExistDriverValidationByEmail(driverDTO.getEmail());
            if (driverDTO1 == null) {

                DriverEntity driverEntity = new DriverEntity();
                BeanUtils.copyProperties(driverDTO, driverEntity);
                boolean saveingToDB = driverDAO.saveingToDB(driverEntity);
                if (saveingToDB) {
                    return "Registeration Done, Data saved to DB";
                } else {
                    return "Data not saved to DB";
                }
            } else {
                return "Driver Details Already Exist bro";
            }
        }
        return "Not Registered, Enter valid Data";
    }

    @Override
    public DriverDTO findingExistDriverValidationByEmail(String email) {
        DriverEntity driverEntity = driverDAO.findingExistDriverInDBByEmail(email);
        if (driverEntity != null) {
            DriverDTO driverDTO = new DriverDTO();
            BeanUtils.copyProperties(driverEntity, driverDTO);
            return driverDTO;
        }
        return null;
    }

    @Override
    public List<DriverDTO> fetchingDataValidation() {
        List<DriverEntity> driverEntities = driverDAO.fetchingAllDataFromDB();
        if (!driverEntities.isEmpty()) {

            List<DriverDTO> driverDTOS = new ArrayList<>();

            driverEntities.forEach(driverEntity -> {

                DriverDTO driverDTO = new DriverDTO();
                BeanUtils.copyProperties(driverEntity, driverDTO);
                driverDTOS.add(driverDTO);
            });
            return driverDTOS;
        }
        return Collections.emptyList();
    }

    @Override
    public DriverDTO findAndFetchDriverValidation(Integer id) {

        DriverEntity driverEntity = driverDAO.findAndFetchDriverFromDB(id);
        if (id != 0) {
            DriverDTO driverDTO=new DriverDTO();
            BeanUtils.copyProperties(driverEntity,driverDTO);
            return driverDTO;
        }
        return null;
    }

    @Override
    public void  updateDriverDetails(DriverDTO driverDTO) {
        DriverEntity driverEntity=new DriverEntity();
        BeanUtils.copyProperties(driverDTO,driverEntity);
        driverDAO.updatingDriverDetailsInDB(driverEntity);
    }

    @Override
    public void deletingDriverData(String email) {
        driverDAO.DeletingDataFromDB(email);
    }

}
