package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dao.UserDAO;
import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import com.xworkz.xworkz_Prasad_Modules.entity.FileEntity;
import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import com.xworkz.xworkz_Prasad_Modules.utility.CryptoUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public String registrationValidation(UserDTO userDTO) {
        UserDTO email = checkingExistUserByEmail(userDTO.getEmail());
        if (email == null) {

            try {
                // Encrypting password here//
                String encryptedPassword = CryptoUtil.encrypt(userDTO.getPassword());
                userDTO.setPassword(encryptedPassword);

                //Convert DTO → Entity
                UserEntity userEntity = new UserEntity();
                BeanUtils.copyProperties(userDTO, userEntity);

                //FILE LOGIC
                MultipartFile file = userDTO.getFile();
                if (file != null && !file.isEmpty()) {

                    // Create unique file name
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();

                    // File path
                    String fullPath = "J:\\xworkz\\projectImages\\" + fileName;

                    // Save file physically
                    Path filePath = Paths.get(fullPath);
                    file.transferTo(filePath.toFile());

                    // Save file metadata
                    FileEntity fileEntity = new FileEntity();
                    fileEntity.setFile(fileName); // store name or full path
                    fileEntity.setContentType(file.getContentType());
                    fileEntity.setSize(file.getSize());
                    fileEntity.setPath(fullPath);

                    // Link with user
                    fileEntity.setUser(userEntity);   // if mapping exists
                    userEntity.setFileEntity(fileEntity);
                }

                //Save file physically
                Path filePath = Paths.get("J:\\xworkz\\projectImages\\" + file.getOriginalFilename() + System.currentTimeMillis() + ".jpg");


                boolean saveDB = userDAO.userSaveDB(userEntity);
                if (saveDB) {
                    return "Registration Done";
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
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

//    @Override
//    public boolean updatingPassword(UserDTO userDTO) {
//
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(userDTO, userEntity);
//        return userDAO.updatingPasswordInDB(userEntity);
//    }


    @Override
    public boolean updatingPassword(UserDTO userDTO) {

        try {
            String encryptedPassword = CryptoUtil.encrypt(userDTO.getPassword());
            userDTO.setPassword(encryptedPassword);

            UserEntity userEntity = userDAO.checkingExistUserInDBByEmail(userDTO.getEmail());

            if (userEntity != null) {
                userEntity.setPassword(encryptedPassword);
                return userDAO.updatingPasswordInDB(userEntity);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}
