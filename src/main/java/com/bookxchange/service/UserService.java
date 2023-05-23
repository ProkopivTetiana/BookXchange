package com.bookxchange.service;

import com.bookxchange.dto.UserDTO;
import com.bookxchange.dto.UserSaveDTO;
import com.bookxchange.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    UserDTO getUserByEmail(String email);

    UserSaveDTO updateUser(UserSaveDTO userSaveDTO);
}
