package com.bookxchange.mapper;

import com.bookxchange.dto.UserDTO;
import com.bookxchange.model.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface UserMapper {
    User dtoToEntity(UserDTO userDTO);

    UserDTO entityToDto(User user);

}