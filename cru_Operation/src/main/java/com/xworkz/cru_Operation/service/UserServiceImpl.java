package com.xworkz.cru_Operation.service;

import com.xworkz.cru_Operation.dao.UserDAO;
import com.xworkz.cru_Operation.dto.UserDTO;
import com.xworkz.cru_Operation.entity.UserEntity;
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
    public String userValidation(UserDTO userDTO) {

        if (userDTO.getAge() != null && userDTO.getAge() > 18 && userDTO.getAge() < 100 &&
                userDTO.getName() != null && !userDTO.getName().trim().isEmpty() && userDTO.getName().length() >= 4 && userDTO.getName().matches("[a-zA-Z ]+") &&
                userDTO.getEmail() != null && !userDTO.getEmail().trim().isEmpty() && userDTO.getEmail().contains("@") && userDTO.getEmail().contains(".") &&
                userDTO.getGender() != null && (userDTO.getGender().equalsIgnoreCase("Male") || userDTO.getGender().equalsIgnoreCase("Female") || userDTO.getGender().equalsIgnoreCase("Other")) &&
                userDTO.getContactNumber() != null &&
                String.valueOf(userDTO.getContactNumber()).length() == 10) {

            UserDTO getExistingUserValidationByEmail = getExistingUserValidationByEmail(userDTO.getEmail());
            if (getExistingUserValidationByEmail == null) {
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(userDTO, userEntity);
                if (userDAO.userDetailsSaveToDb(userEntity)) {
                    return "Registration Done, User Data Saved to Db";
                } else {
                    return "User Data failed to save";
                }

            } else {
                return "User Details alredy exist in DataBase";
            }
        } else {
            return "Enter valid User Details";
        }
    }

    @Override
    public UserDTO getExistingUserValidationByEmail(String email) {
        UserEntity existUserByEmail = userDAO.getExistUserByEmail(email);
        if (existUserByEmail != null) {

            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(existUserByEmail, userDTO);
            return userDTO;
        }
        return null;
    }

    @Override
    public List<UserDTO> getAllUsersListFromDB() {

        List<UserEntity> allUsersListfromDB = userDAO.getAllUsersListfromDB();
        if (!allUsersListfromDB.isEmpty()) {

            List<UserDTO> userDTOS = new ArrayList<>();
            allUsersListfromDB.forEach(userEntity -> {

                UserDTO userDTO = new UserDTO();

                BeanUtils.copyProperties(userEntity, userDTO);

                userDTOS.add(userDTO);
            });

            return userDTOS;
        }
        return Collections.emptyList();
    }

    @Override
    public UserDTO getExistingUserToUpdateData(Integer id) {

        UserEntity userEntity = userDAO.getingUserToUpdateDataFromDBByID(id);
        if (id != 0) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        }
        return null;
    }

}
