package com.kpi.project.model.mapper;

import com.kpi.project.model.User;
import com.kpi.project.model.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User dtoToUser(UserDto userDto) {
        final User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUsername(userDto.getUsername());

        return user;
    }

    public UserDto userToDto(User user) {
        final Set<String> newRoles = user.getRoles().stream()
                .map(Enum::toString)
                .collect(Collectors.toSet());

        final UserDto userDto = UserDto.builder()
                .email(user.getEmail())
                .password(user.getPassword())
                .username(user.getUsername())
                .roles(newRoles)
                .build();

        return userDto;
    }
}
