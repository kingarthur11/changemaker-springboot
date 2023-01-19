package com.example.checkmaker.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserAuthRequestDTO {

    private Integer id;
    @NotBlank(message = "Invalid name: Empty name")
    @NotNull(message = "Invalid name: name is null")
    @Size(min = 3, max = 30, message = "Invalid name: must be of 3 - 30 characters")
    String fullname;

    @Email(message = "Invalid email")
    String userEmail;

    @NotNull(message = "Invalid phone number: empty number")
    @NotNull(message = "Invalid phone number: number is null")
    @Pattern(regexp = "^\\d{10}$", message = "invalid phone number")
    @Size(min = 3, max = 30, message = "Invalid phone number: must be of 3 - 30 characters")
    String userPhoneNo;
    String username;
}
