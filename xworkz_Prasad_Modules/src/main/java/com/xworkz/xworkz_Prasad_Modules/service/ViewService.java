package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;

import java.util.List;

public interface ViewService {
    UserDTO readUsearToUpdateData(String email);

    boolean updateExistUserData(UserDTO userDTO);

    List<UserDTO> readAllUsersList();
}
