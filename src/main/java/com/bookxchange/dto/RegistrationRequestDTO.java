package com.bookxchange.dto;

import javax.validation.constraints.NotNull;

import com.bookxchange.validator.EmailConstraint;
import com.bookxchange.validator.NameConstraint;
import com.bookxchange.validator.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}