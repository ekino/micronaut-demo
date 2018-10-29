package com.ekino.micronaut.user.mapper;

import com.ekino.micronaut.user.domain.User;
import com.ekino.micronaut.user.dto.UserDto;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    static UserMapper getInstance() {
        return Mappers.getMapper(UserMapper.class);
    }

    UserDto userToUserDto(User source);

}
