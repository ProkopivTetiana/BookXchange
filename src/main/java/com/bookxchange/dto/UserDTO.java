package com.bookxchange.dto;

import com.bookxchange.model.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class UserDTO {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private Role role;
    private String password;
    private String repeatPassword;
    private String contactInfo;

    public UserDTO(String firstName,
                   String lastName,
                   String email,
                   String password,
                   String repeatPassword,
                   Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.role = role;
    }
}