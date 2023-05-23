package com.bookxchange.dto;

import javax.validation.constraints.NotNull;

import com.bookxchange.validator.EmailConstraint;
import com.bookxchange.validator.PasswordConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestDTO {
    @NotNull
    @EmailConstraint
    private String email;

    @NotNull
    @PasswordConstraint
    private String password;
}
