package ru.sibsutis.dormitory.server.model.dto.security.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Базовая dto для заведения пользователя
 */
@Data
public class UserBasicInfoDto {

    @JsonProperty("email")
    private String userEmail;

    @JsonProperty("password")
    private String userPassword;

}
