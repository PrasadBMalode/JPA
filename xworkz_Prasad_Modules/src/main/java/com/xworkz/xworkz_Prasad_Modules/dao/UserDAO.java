package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;

public interface UserDAO {

    boolean userSaveDB(UserEntity userEntity);

    UserEntity checkingExistUserInDBByEmail(String email);
}
