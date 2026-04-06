package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dao.OtpDAO;
import com.xworkz.xworkz_Prasad_Modules.entity.OtpEntity;
import com.xworkz.xworkz_Prasad_Modules.utility.OTPVerificationMail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    OtpDAO otpDAO;

    @Autowired
    OTPVerificationMail mail;

    // SEND OTP
    public void sendOtp(String email) {

        String otp = mail.sendOTP(email);

        OtpEntity entity = new OtpEntity();
        entity.setEmail(email);
        entity.setOtp(otp);
        entity.setExpiryTime(System.currentTimeMillis() + (30 * 1000)); // 30 sec
        entity.setAttempts(0);

        otpDAO.saveOtp(entity);
    }

    // VERIFY OTP
    public boolean verifyOtp(String email, String userOtp) {

        OtpEntity entity = otpDAO.findByEmail(email);

        if (entity == null) return false;

        // expiry
        if (System.currentTimeMillis() > entity.getExpiryTime()) {
            return false; // ❗ no delete
        }

        // attempts
        if (entity.getAttempts() >= 3) {
            return false; // ❗ no delete
        }

        // correct OTP
        if (entity.getOtp().equals(userOtp)) {

            // ✔ clear only OTP fields (NOT delete row)
            entity.setOtp(null);
            entity.setExpiryTime(0);
            entity.setAttempts(0);

            otpDAO.saveOtp(entity);
            return true;
        }

        // wrong OTP
        entity.setAttempts(entity.getAttempts() + 1);
        otpDAO.saveOtp(entity);

        return false;
    }
}
