package com.xworkz.xworkz_Prasad_Modules.service;

import com.xworkz.xworkz_Prasad_Modules.dao.LoginDAO;
import com.xworkz.xworkz_Prasad_Modules.entity.UserEntity;
import com.xworkz.xworkz_Prasad_Modules.utility.CryptoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginDAO loginDAO;

    @Override
    public String loginValidation(String email, String password) {
        UserEntity user = loginDAO.findByEmail(email);

        // Check if user exists
        if (user == null) {
            return "EMAIL_NOT_FOUND";
        }

        // Check if account is already locked
        if (user.getAccountLocked() != null && user.getAccountLocked()) {
            // User already blocked due to previous failed attempts
            System.out.println("Account is blocked!");
            return "ACCOUNT_BLOCKED";
        }
        String decryptedPassword = CryptoUtil.decrypt(user.getPassword());
        if (decryptedPassword.equals(password)) {
            user.setLoginAttempts(0);
            loginDAO.updateUser(user);
            return "LOGIN_SUCCESS";
        } else {

            //Password is incorrect
            Integer attempts = user.getLoginAttempts() == null ? 0 : user.getLoginAttempts();
            attempts++;
            user.setLoginAttempts(attempts);

            // if attempts reached limit (3)
            if (attempts >= 3) {
                user.setAccountLocked(true);
                System.out.println("Account blocked after 3 attempts!");
                loginDAO.updateUser(user);
                return "ACCOUNT_BLOCKED";
            }

            loginDAO.updateUser(user);
            return "INVALID_PASSWORD";
        }
    }
}
