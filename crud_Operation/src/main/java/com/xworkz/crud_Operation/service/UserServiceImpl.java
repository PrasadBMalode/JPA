package com.xworkz.crud_Operation.service;

import com.xworkz.crud_Operation.dao.UserDAO;
import com.xworkz.crud_Operation.dto.UserDTO;
import com.xworkz.crud_Operation.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public String newUserValidation(UserDTO userDTO) {
        if (userDTO.getAge() != null && userDTO.getAge() > 18
                && userDTO.getName() != null && !userDTO.getName().trim().isEmpty()
                && userDTO.getLocation() != null && !userDTO.getLocation().trim().isEmpty()
                && userDTO.getPhNumber() != null && String.valueOf(userDTO.getPhNumber()).length() == 10) {

            UserDTO userDTO1 = userExistValidation(userDTO.getPhNumber());
            if (userDTO1 == null) {
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(userDTO, userEntity);
                boolean saveDB = userDAO.saveDB(userEntity);
                return "Register Successfully, Data saved in DB";
            }
            return "User already exist...!";
        }

        return "Registration failed, Please enter valid data...!";
    }

    @Override
    public UserDTO userExistValidation(long phNumber) {
        UserEntity userEntity = userDAO.checkingExistUserDataInDB(phNumber);
        if (userEntity != null) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public List<UserDTO> readAllDataValidation() {
        List<UserEntity> userEntities = userDAO.readAllDataFromDB();
        if (!userEntities.isEmpty()) {

            List<UserDTO> userDTOS = new ArrayList<>();

            userEntities.forEach(userEntity -> {

                UserDTO userDTO = new UserDTO();
                BeanUtils.copyProperties(userEntity, userDTO);
                userDTOS.add(userDTO);
            });
            return userDTOS;
        }
        return Collections.emptyList();
    }

    @Override
    public UserDTO fetchingDTO(Integer id) {
        UserEntity userEntity = userDAO.fetchingDtoFromDB(id);
        if (id!=0){
            UserDTO userDTO=new UserDTO();
            BeanUtils.copyProperties(userEntity,userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public void updateValidation(UserDTO userDTO) {
        UserEntity userEntity=new UserEntity();
        BeanUtils.copyProperties(userDTO,userEntity);
        userDAO.updatedDataSaveDB(userEntity);
    }

    @Override
    public void deletingDataValidation(Long phNumber) {
        userDAO.deletingUserDataInDB(phNumber);

    }
}
