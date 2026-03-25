package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;

public interface LoginDAO {
    //String loginDataCheckInDB(String email);

    UserEntity findByEmail(String email);
    void updateUser (UserEntity user);
}
