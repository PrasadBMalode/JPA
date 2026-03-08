package com.xworkz.crud_Operation.dao;

import com.xworkz.crud_Operation.entity.UserEntity;

import java.util.List;

public interface UserDAO {

    boolean saveDB(UserEntity userEntity);

    UserEntity checkingExistUserDataInDB(Long phNumber);

    List<UserEntity> readAllDataFromDB();

    UserEntity fetchingDtoFromDB(Integer id);

    void updatedDataSaveDB(UserEntity userEntity);

    void deletingUserDataInDB(Long phNumber);
}
