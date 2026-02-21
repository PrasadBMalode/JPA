package com.xworkz.travalerPortal.service;

import com.xworkz.travalerPortal.dao.TravalerDAO;
import com.xworkz.travalerPortal.dto.TravalerDTO;
import com.xworkz.travalerPortal.entity.TravalerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class TravelerServiceImpl implements TravelerService {

    @Autowired
    TravalerDAO travalerDAO;

    @Override
    public boolean registerValidation(TravalerDTO travalerDTO) {
        System.out.println("service===" + travalerDTO);

        if (travalerDTO.getAge() != null && travalerDTO.getAge() > 18 &&
                travalerDTO.getName() != null && travalerDTO.getName().length() > 4 &&
                travalerDTO.getLocation() != null && travalerDTO.getLocation().length() > 5 &&
                travalerDTO.getNumber() != null) {

            TravalerEntity travalerEntity = new TravalerEntity();
            travalerEntity.setAge(travalerDTO.getAge());
            travalerEntity.setName(travalerDTO.getName());
            travalerEntity.setLocation(travalerDTO.getLocation());
            travalerEntity.setNumber(travalerDTO.getNumber());

            travalerDAO.saveDB(travalerEntity);
            return true;


        } else {
            return false;
        }


    }

    @Override
    public List<TravalerDTO> readAllData() {
        List<TravalerEntity> travalerEntities = travalerDAO.readPassangerData();

        if (!travalerEntities.isEmpty()) {

            List<TravalerDTO> travalerDTOS = new ArrayList();

            travalerEntities.forEach(travalerEntity -> {

                TravalerDTO travalerDTO = new TravalerDTO();

                travalerDTO.setAge(travalerEntity.getAge());
                travalerDTO.setName(travalerEntity.getName());
                travalerDTO.setLocation(travalerEntity.getLocation());
                travalerDTO.setNumber(travalerEntity.getNumber());

                travalerDTOS.add(travalerDTO);

            });

            return travalerDTOS;
        } else {
            return Collections.emptyList();

        }
    }
}
