package com.xworkz.cru_Operation.service;

import com.xworkz.cru_Operation.dto.UserDTO;

import java.util.List;

public interface UserService {

    String userValidation(UserDTO userDTO);

    UserDTO getExistingUserValidationByEmail(String email);

    List<UserDTO> getAllUsersListFromDB();

    UserDTO getExistingUserToUpdateData(Integer id);
}
