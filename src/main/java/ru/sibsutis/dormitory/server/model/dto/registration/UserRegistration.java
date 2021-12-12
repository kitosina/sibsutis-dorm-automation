package ru.sibsutis.dormitory.server.model.dto.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Базовая dto для заведения пользователя
 */
@Data
public class UserRegistration {

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("password")
    private String userPassword;

}
