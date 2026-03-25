package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;

import java.util.List;

public interface ViewDAO {
    UserEntity readUserDataToUpdate(String email);

    boolean updatingExistUserDataInDB(UserEntity userEntity);

    List<UserEntity> readAllUsersFromDB();
}
