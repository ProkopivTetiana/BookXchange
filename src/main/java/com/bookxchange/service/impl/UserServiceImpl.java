package com.bookxchange.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookxchange.dto.UserDTO;
import com.bookxchange.dto.UserNameDTO;
import com.bookxchange.dto.UserSaveDTO;
import com.bookxchange.exception.EntityNotExistsException;
import com.bookxchange.mapper.UserMapper;
import com.bookxchange.model.User;
import com.bookxchange.repository.UserRepository;
import com.bookxchange.service.UserService;

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
        return userMapper.entityToDto(userRepository.findByEmail(email)
            .orElseThrow(EntityNotExistsException::new));
    }

    @Override
    public UserSaveDTO updateUser(String id, UserSaveDTO userSaveDTO) {
        return userRepository.findById(id)
            .map(user -> userMapper.entityToSaveDto(
                updateUser(user, userSaveDTO)))
            .orElseThrow(EntityNotExistsException::new);
    }

    @Override public UserNameDTO getUserNameById(String id) {
        return userRepository.findById(id).map(userMapper::entityToNameDto)
            .orElseThrow(EntityNotExistsException::new);
    }

    User updateUser(User user, UserSaveDTO userSaveDTO) {
        if (userSaveDTO.getFirstName() != null && !userSaveDTO.getFirstName()
            .isBlank()) {
            user.setFirstName(userSaveDTO.getFirstName());
        }
        if (userSaveDTO.getEmail() != null && !userSaveDTO.getEmail()
            .isBlank()) {
            user.setEmail(userSaveDTO.getEmail());
        }
        if (userSaveDTO.getLastName() != null && !userSaveDTO.getLastName()
            .isBlank()) {
            user.setLastName(userSaveDTO.getLastName());
        }
        if (userSaveDTO.getContactInfo() != null
            && !userSaveDTO.getContactInfo().isBlank()) {
            user.setContactInfo(userSaveDTO.getContactInfo());
        }
        return userRepository.save(user);
    }
}
