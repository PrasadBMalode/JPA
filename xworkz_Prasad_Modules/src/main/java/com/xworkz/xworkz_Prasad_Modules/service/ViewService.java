package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ViewService {
    UserDTO readUsearToUpdateData(String email);

    boolean updateFullProfile(UserDTO userDTO, MultipartFile file);

    List<UserDTO> readAllUsersList();


}
