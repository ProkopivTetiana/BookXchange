package com.bookxchange.service;

import java.util.List;

import com.bookxchange.dto.UserDTO;
import com.bookxchange.dto.UserNameDTO;
import com.bookxchange.dto.UserSaveDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserDTO getUserByEmail(String email);

    UserSaveDTO updateUser(String id, UserSaveDTO userSaveDTO);

    UserNameDTO getUserNameById(String id);

    List<UserDTO> getAllUsers();
}
