package ru.sibsutis.dormitory.server.model.entity.security;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    /**
     * Роль USER
     */
    USER,
    /**
     * Роль ADMIN
     */
    ADMIN;

    /**
     * Automatically generated method for authorities and role system in Spring Security
     * @see Override
     * @see org.springframework.security.authentication.jaas.AuthorityGranter
     */
    @Override
    public String getAuthority() {
        return name();
    }
}
