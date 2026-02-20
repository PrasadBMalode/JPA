package com.xworkz.getData.service;

import com.xworkz.getData.dao.GetDataDAO;
import com.xworkz.getData.dto.GetDataDTO;
import com.xworkz.getData.entity.GetDataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GetDataServiceImpl implements GetDataService {

    @Autowired
    GetDataDAO getDataDAO;

    @Override
    public List<GetDataDTO> readAllData() {

        List<GetDataEntity> getDataEntities = getDataDAO.getDBData();


        if (!getDataEntities.isEmpty()) {
            List<GetDataDTO> getDataDTOList = new ArrayList();

            getDataEntities.forEach(getDataEntity -> {

                GetDataDTO getDataDTO = new GetDataDTO();

                getDataDTO.setAge(getDataEntity.getAge());
                getDataDTO.setName(getDataEntity.getName());
                getDataDTO.setLocation(getDataEntity.getLocation());
                getDataDTO.setNumber(getDataEntity.getNumber());

                getDataDTOList.add(getDataDTO);
            });

            return getDataDTOList;

        } else {
            return Collections.emptyList();
        }

    }
}
