package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dao.ViewDAO;
import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    ViewDAO viewDAO;

    @Override
    public UserDTO readUsearToUpdateData(String email) {
        UserEntity userEntity = viewDAO.readUserDataToUpdate(email);
        if (userEntity != null) {

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public boolean updateExistUserData(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDTO, userEntity);

        return viewDAO.updatingExistUserDataInDB(userEntity);
    }

    @Override
    public List<UserDTO> readAllUsersList() {
        List<UserEntity> userEntities = viewDAO.readAllUsersFromDB();

        if (!userEntities.isEmpty()) {

            List<UserDTO> userDTOS=new ArrayList<>();

            userEntities.forEach(userEntity -> {

                UserDTO userDTO=new UserDTO();
                BeanUtils.copyProperties(userEntity,userDTO);
                userDTOS.add(userDTO);
            });

            return userDTOS;
        }
        return Collections.emptyList();
    }
}
