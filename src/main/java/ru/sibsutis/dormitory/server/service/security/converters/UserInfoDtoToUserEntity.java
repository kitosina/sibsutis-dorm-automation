package ru.sibsutis.dormitory.server.service.security.converters;

import ru.sibsutis.dormitory.server.model.entity.security.Role;
import ru.sibsutis.dormitory.server.model.entity.security.UserEntity;

import java.util.Set;

public class UserInfoDtoToUserEntity {

    public UserEntity convert(final String email, final String password, final Set<Role> role) {
        return UserEntity.builder()
                .email(email)
                .password(password)
                .roles(role)
                .build();
    }

}
