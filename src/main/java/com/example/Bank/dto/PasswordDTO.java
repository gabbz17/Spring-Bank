package com.example.Bank.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PasswordDTO {

    @NotBlank
    @Size(min = 6, max = 10)
    private String password;
    @NotBlank
    @Size(min = 6, max = 10)
    private String newPassword;
    @NotBlank
    @Size(min = 6, max = 10)
    private String confirmNewPassword;
}
