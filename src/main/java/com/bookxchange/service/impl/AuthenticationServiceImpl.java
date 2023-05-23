package com.bookxchange.service.impl;

import com.bookxchange.dto.AuthenticationRequestDTO;
import com.bookxchange.dto.AuthenticationResponseDTO;
import com.bookxchange.dto.RegistrationRequestDTO;
import com.bookxchange.dto.UserDTO;
import com.bookxchange.mapper.UserMapper;
import com.bookxchange.model.Role;
import com.bookxchange.repository.UserRepository;
import com.bookxchange.service.AuthenticationService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    public final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponseDTO register(RegistrationRequestDTO request) {
        UserDTO userDTO =
                new UserDTO(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        Role.USER);
        userRepository.save(userMapper.dtoToEntity(userDTO));
        var jwtToken =
                jwtService.generateToken(userMapper.dtoToEntity(userDTO));
        return AuthenticationResponseDTO.builder()
                .jwt(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponseDTO authenticate(
            AuthenticationRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken =
                jwtService.generateToken(user);
        return AuthenticationResponseDTO.builder()
                .jwt(jwtToken)
                .build();
    }
}