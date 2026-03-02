package com.xworkz.cru_Operation.dao;

import com.xworkz.cru_Operation.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    boolean userDetailsSaveToDb(UserEntity userEntity);

    UserEntity getExistUserByEmail(String email);

    List<UserEntity> getAllUsersListfromDB();

    UserEntity getingUserToUpdateDataFromDBByID(Integer id);
}
