package com.bookxchange.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookxchange.dto.UserDTO;
import com.bookxchange.dto.UserNameDTO;
import com.bookxchange.dto.UserSaveDTO;
import com.bookxchange.service.UserService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/profile")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<UserDTO> getUser(@NotNull Principal principal) {
        UserDTO userDTO = userService.getUserByEmail(principal.getName());
        return ResponseEntity.status(HttpStatus.OK).body(userDTO);
    }

    @PatchMapping(path = "/profile/{id}")
    @PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
    public ResponseEntity<UserSaveDTO> updateUser(
        @PathVariable @NotNull String id, @RequestBody UserSaveDTO userSaveDTO) {
        UserSaveDTO user = userService.updateUser(id, userSaveDTO);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/profile/name/{id}")
    public ResponseEntity<UserNameDTO> getUserNameById(
        @PathVariable @NotNull String id) {
        UserNameDTO user = userService.getUserNameById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }
}
