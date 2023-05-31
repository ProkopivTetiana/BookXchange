package com.bookxchange.dto;

import com.bookxchange.model.Role;
import com.bookxchange.validator.EmailConstraint;
import com.bookxchange.validator.NameConstraint;
import com.bookxchange.validator.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequestDTO {
    @NotNull
    @NameConstraint
    private String firstName;

    @NotNull
    @NameConstraint
    private String lastName;

    @NotNull
    @EmailConstraint
    private String email;

    @NotNull
    @PasswordConstraint
    private String password;

    @NotNull
    @PasswordConstraint
    private String repeatPassword;

    @NotNull
    private Role role;
}