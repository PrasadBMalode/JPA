package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dao.ViewDAO;
import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import com.xworkz.xworkz_Prasad_Modules.entity.FileEntity;
import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public boolean updateFullProfile(UserDTO userDTO, MultipartFile file) {

        try {
            UserEntity existingUser = viewDAO.readUserDataToUpdate(userDTO.getEmail());

            if (existingUser != null) {

                // update normal fields
                existingUser.setName(userDTO.getName());
                existingUser.setDob(userDTO.getDob());
                existingUser.setAge(userDTO.getAge());
                existingUser.setLocation(userDTO.getLocation());

                // IMAGE UPDATE
                if (file != null && !file.isEmpty()) {

                    // delete old image
                    if (existingUser.getFileEntity() != null) {
                        File oldFile = new File(existingUser.getFileEntity().getPath());
                        if (oldFile.exists()) {
                            oldFile.delete();
                        }
                    }

                    // save new image
                    String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                    String fullPath = "J:\\xworkz\\projectImages\\" + fileName;

                    Path path = Paths.get(fullPath);
                    file.transferTo(path.toFile());

                    // ✅ FIX: ALWAYS CREATE NEW ENTITY (DON'T REUSE OLD)
                    FileEntity fileEntity = new FileEntity();

                    fileEntity.setFile(fileName);
                    fileEntity.setPath(fullPath);
                    fileEntity.setContentType(file.getContentType());
                    fileEntity.setSize(file.getSize());

                    // ✅ FIX: SET BOTH SIDES
                    fileEntity.setUser(existingUser);
                    existingUser.setFileEntity(fileEntity);
                }

                return viewDAO.updatingExistUserDataInDB(existingUser);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return false;
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