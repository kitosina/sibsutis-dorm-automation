package ru.sibsutis.dormitory.server.service.security.strategy;

import org.springframework.web.multipart.MultipartFile;
import ru.sibsutis.dormitory.server.model.dto.security.request.UserInfoDto;
import ru.sibsutis.dormitory.server.model.entity.security.Role;

import java.util.Set;

public interface RegistrationStrategy {

    /**
     * Регистрация пользователя в системе
     * @param documentScanOne
     * @param documentScanTwo
     * @param userInfoDto
     */
    void registrationUser(final MultipartFile documentScanOne, final MultipartFile documentScanTwo,
                                             final UserInfoDto userInfoDto);

    Set<Role> getRegistrationRoleUser();

    /**
     * Валидация уникальных полей
     * @param userInfoDto
     */
    void validate(final UserInfoDto userInfoDto);

}
