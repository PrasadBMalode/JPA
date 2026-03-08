package com.xworkz.crud_Operation.service;

import com.xworkz.crud_Operation.dto.UserDTO;

import java.util.List;

public interface UserService {

    String newUserValidation(UserDTO userDTO);

    UserDTO userExistValidation(long phNumber);

    List<UserDTO> readAllDataValidation();

    UserDTO fetchingDTO(Integer id);

    void updateValidation(UserDTO userDTO);

    void deletingDataValidation(Long phNumber);
}
