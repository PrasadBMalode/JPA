package com.xworkz.xworkz_Prasad_Modules.dao;

import com.xworkz.xworkz_Prasad_Modules.entity.OtpEntity;


public interface OtpDAO {

    void saveOtp(OtpEntity otpEntity);

    OtpEntity findByEmail(String email);

    void deleteByEmail(String email);

}
