package com.xworkz.xworkz_Prasad_Modules.service;

public interface OtpService {

    void sendOtp(String email);

    boolean verifyOtp(String email, String userOtp);

}
