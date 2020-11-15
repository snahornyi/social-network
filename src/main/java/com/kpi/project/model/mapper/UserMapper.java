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
        final UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setUsername(user.getUsername());

        final Set<String> newRoles = user.getRoles().stream()
                .map(Enum::toString)
                .collect(Collectors.toSet());
        userDto.setRoles(newRoles);

        return userDto;
    }
}
