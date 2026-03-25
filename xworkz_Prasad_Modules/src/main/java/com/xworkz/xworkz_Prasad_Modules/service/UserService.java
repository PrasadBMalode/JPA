package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dto.UserDTO;

public interface UserService {

    String registrationValidation(UserDTO userDTO);

    UserDTO checkingExistUserByEmail(String email);
}
