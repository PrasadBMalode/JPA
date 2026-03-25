package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dao.UserDAO;
import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import com.xworkz.xworkz_Prasad_Modules.utility.CryptoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public String registrationValidation(UserDTO userDTO) {
        UserDTO email = checkingExistUserByEmail(userDTO.getEmail());
        if (email == null) {

            // Encrypting password here//
            String encryptedPassword = CryptoUtil.encrypt(userDTO.getPassword());
            userDTO.setPassword(encryptedPassword);
            System.out.println("Encrypting password to save in DB=="+encryptedPassword);

            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDTO, userEntity);
            boolean saveDB = userDAO.userSaveDB(userEntity);
            if (saveDB) {
                return "Registration Done";
            }
            return "Registration Failed...!";
        }
        return "User already exist";

    }

    @Override
    public UserDTO checkingExistUserByEmail(String email) {
        UserEntity userEntity = userDAO.checkingExistUserInDBByEmail(email);
        if (userEntity != null) {
            UserDTO userDTO = new UserDTO();
            BeanUtils.copyProperties(userEntity, userDTO);
            return userDTO;
        }
        return null;
    }
}
