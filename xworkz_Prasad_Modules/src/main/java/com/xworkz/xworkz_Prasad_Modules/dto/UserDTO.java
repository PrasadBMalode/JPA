package com.xworkz.xworkz_Prasad_Modules.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[A-Za-z\\s]{3,}$", message = "Name must contain only letters (minimum 3)")
    private String name;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Past(message = "DOB must be in the past")
    private LocalDate dob;

    @NotNull
    @Min(value = 18, message = "Age must be 18 or above")
    private Integer age;

    @NotBlank(message = "Please select gender")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Invalid gender")
    private String gender;

    @NotBlank(message = "Location is required")
    @Pattern(regexp = "^[A-Za-z\\s]{4,}$", message = "Location must contain minimum 4 letters")
    private String location;

    @NotBlank(message = "Email is required")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@gmail\\.com$", message = "Email must be Gmail address")
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "^[6-9][0-9]{9}$", message = "Phone must start with 6,7,8,9 and be 10 digits")
    private String phNumber;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,12}$", message = "Password must be 8-12 chars with uppercase, lowercase, number & special char")
    private String password;

    @NotBlank(message = "Confirm password is required")
    private String confirmPassword;
}