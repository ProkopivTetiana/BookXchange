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
}