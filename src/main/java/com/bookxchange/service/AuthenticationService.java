package com.bookxchange.service;


import com.bookxchange.dto.AuthenticationRequestDTO;
import com.bookxchange.dto.AuthenticationResponseDTO;
import com.bookxchange.dto.RegistrationRequestDTO;

public interface AuthenticationService {
    AuthenticationResponseDTO register(RegistrationRequestDTO request);

    AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request);
}
