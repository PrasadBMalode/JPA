package com.xworkz.readData.service;

import com.xworkz.readData.dao.ReadDataDAO;
import com.xworkz.readData.dto.ReadDataDTO;
import com.xworkz.readData.entity.ReadDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ReadDataServiceImpl implements ReadDataService {

    @Autowired
    ReadDataDAO readDataDAO;

    @Override
    public List<ReadDataDTO> readDTO() {

        List<ReadDataEntity> readDataEntities = readDataDAO.readDB();


        if (!readDataEntities.isEmpty()) {
            List<ReadDataDTO> readDataDTOS = new ArrayList<>();

            readDataEntities.forEach(readDataEntity -> {

                ReadDataDTO readDataDTO = new ReadDataDTO();
                readDataDTO.setAge(readDataEntity.getAge());
                readDataDTO.setName(readDataEntity.getName());
                readDataDTO.setLocation(readDataEntity.getLocation());
                readDataDTO.setNumber(readDataEntity.getNumber());

                readDataDTOS.add(readDataDTO);


            });

            return readDataDTOS;
        } else {
            return Collections.emptyList();
        }

    }
}
