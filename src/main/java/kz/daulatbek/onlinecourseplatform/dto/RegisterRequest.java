package kz.daulatbek.onlinecourseplatform.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Full name cannot be empty")
    private String fullName;

    @Email(message = "Invalid email")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;
}