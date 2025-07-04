package com.ExpenseTracker.Tracker.mapper;


import com.ExpenseTracker.Tracker.dto.UserDto;
import com.ExpenseTracker.Tracker.dto.UserRegistrationDto;
import com.ExpenseTracker.Tracker.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

        User toUser(UserDto userDTO);
        UserDto toUserDto(User user);
        List<UserDto> toUserDTOs(List<User> users);
        User toUserFromRegistration(UserRegistrationDto dto);

    }




















//public UserDto toDTO(User user) {
//    if (user == null) return null;
//    UserDto dto = new UserDto();
//    dto.setId(user.getId());
//    dto.setUsername(user.getUsername());
//    dto.setEmail(user.getEmail());
//    dto.setFullName(user.getFullName());
//    return dto;
//}
//public User toEntity(UserDto dto) {
//    if (dto == null) return null;
//    User user = new User();
//    user.setId(dto.getId());
//    user.setUsername(dto.getUsername());
//    user.setEmail(dto.getEmail());
//    user.setFullName(dto.getFullName());
//    // Password should be set elsewhere (e.g., registration)
//    return user;
//}
