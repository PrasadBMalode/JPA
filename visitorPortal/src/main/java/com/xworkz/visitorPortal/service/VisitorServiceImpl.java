package com.xworkz.visitorPortal.service;

import com.xworkz.visitorPortal.dao.VisitorDAO;
import com.xworkz.visitorPortal.dto.VisitorDTO;
import com.xworkz.visitorPortal.entity.VisitorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    VisitorDAO visitorDAO;

    @Override
    public boolean visitorValidation(VisitorDTO visitorDTO) {
        System.out.println("service===" + visitorDTO);

        if (visitorDTO.getAge() != null && visitorDTO.getAge() > 18 &&
                visitorDTO.getName() != null && visitorDTO.getName().length() > 4 &&
                visitorDTO.getLocation() != null && visitorDTO.getLocation().length() > 5 &&
                visitorDTO.getNumber() != null) {

            VisitorEntity visitorEntity = new VisitorEntity();
            visitorEntity.setAge(visitorDTO.getAge());
            visitorEntity.setName(visitorDTO.getName());
            visitorEntity.setLocation(visitorDTO.getLocation());
            visitorEntity.setNumber(visitorDTO.getNumber());

            visitorDAO.saveDB(visitorEntity);

            return true;

        } else {
            return false;
        }


    }
}
