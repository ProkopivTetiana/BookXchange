package com.bookxchange.service.impl;

import com.bookxchange.dto.UserDTO;
import com.bookxchange.dto.UserNameDTO;
import com.bookxchange.dto.UserSaveDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.UserMapper;
import com.bookxchange.repository.UserRepository;
import com.bookxchange.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.entityToDto(userRepository.findByEmail(email).orElseThrow(EntityNotExistsException::new));
    }

    @Override
    public UserSaveDTO updateUser(UserSaveDTO userSaveDTO) {
        return userRepository.findByEmail(userSaveDTO.getEmail())
                .map(user -> {
                    userMapper.updateUser(user, userSaveDTO);
                    return userMapper.entityToSaveDto(userRepository.save(user));
                }).orElseThrow(EntityNotExistsException::new);
    }

    @Override public UserNameDTO getUserNameById(String id) {
        return userRepository.findById(id).map(userMapper::entityToNameDto).orElseThrow(EntityNotExistsException::new);
    }
}
