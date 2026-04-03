package com.xworkz.xworkz_Prasad_Modules.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OTPVerificationMail {

    @Autowired
    JavaMailSender javaMailSender;

    public String getOTP() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return String.valueOf(otp);

    }

//    public String oTPVerificationMail() {
//
//        String otp = getOTP();
//
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setFrom("malodeprasad666@gmail.com");
//        mailMessage.setTo("prasadbm666@gmail.com");
//        mailMessage.setSubject("OTP");
//        mailMessage.setText("Your OTP is: " + otp);
//
//        return otp;
//    }

    public String sendOTP(String toEmail) {

        String otp = getOTP();

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("your-email@gmail.com");
        mailMessage.setTo(toEmail); // ✅ dynamic email
        mailMessage.setSubject("OTP Verification");
        mailMessage.setText("Your OTP is: " + otp);

        javaMailSender.send(mailMessage); // ✅ SEND EMAIL

        return otp;
    }


}
