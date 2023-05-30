package com.bookxchange.exception;

import com.bookxchange.dto.RegistrationRequestDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InvalidPasswordException extends Exception {
    private static final String INVALID_PASSWORD = "password not valid";
    private RegistrationRequestDTO requestDTO;

    public InvalidPasswordException(String message, RegistrationRequestDTO requestDTO) {
        super(message.isEmpty() ? INVALID_PASSWORD : message);
        this.requestDTO = requestDTO;
    }

    public InvalidPasswordException() {
        super(INVALID_PASSWORD);
    }
}
