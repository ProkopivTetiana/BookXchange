package com.bookxchange.service.impl;

import com.bookxchange.dto.AuthenticationRequestDTO;
import com.bookxchange.dto.AuthenticationResponseDTO;
import com.bookxchange.dto.RegistrationRequestDTO;
import com.bookxchange.dto.UserDTO;
import com.bookxchange.exception.EmailAlreadyTakenException;
import com.bookxchange.mapper.UserMapper;
import com.bookxchange.model.Role;
import com.bookxchange.model.User;
import com.bookxchange.repository.UserRepository;
import com.bookxchange.security.PasswordConfig;
import com.bookxchange.service.AuthenticationService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationServiceImpl implements AuthenticationService {
    private static final String EMAIL_ALREADY_TAKEN = "Email already taken: ";

    public final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final JwtService jwtService;
    private final PasswordConfig passwordConfig;

    @Override
    public AuthenticationResponseDTO register(@NotNull RegistrationRequestDTO request) {
        UserDTO userDTO =
                new UserDTO(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        request.getPassword(),
                        Role.USER);
        User user = userMapper.dtoToEntity(userDTO);
        String encodedPassword = passwordConfig.passwordEncoder()
                .encode(userDTO.getPassword());
        user.setPassword(encodedPassword);
        boolean userExists = userRepository
                .findByEmail(userDTO.getEmail())
                .isPresent();

        if (userExists) {
            throw new EmailAlreadyTakenException(
                    EMAIL_ALREADY_TAKEN + userDTO.getEmail(), userDTO);
        }
        userRepository.save(user);
        var jwtToken =
                jwtService.generateToken(userMapper.dtoToEntity(userDTO));
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
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
                .token(jwtToken)
                .build();
    }
}