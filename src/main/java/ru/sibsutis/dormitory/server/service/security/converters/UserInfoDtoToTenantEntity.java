package ru.sibsutis.dormitory.server.service.security.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.security.request.UserInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.TenantEntity;

public class UserInfoDtoToTenantEntity implements Converter<UserInfoDto, TenantEntity>  {
    @Override
    public TenantEntity convert(UserInfoDto userInfoDto) {
        return TenantEntity.builder()
                .name(userInfoDto.getName())
                .lastName(userInfoDto.getLastName())
                .patronymic(userInfoDto.getPatronymic())
                .passport(userInfoDto.getPassport())
                .email(userInfoDto.getUserBasicInfoDto().getUserEmail())
                .birthDate(userInfoDto.getBirthDate())
                .contractBegin(userInfoDto.getContractBegin())
                .contractEnd(userInfoDto.getContractEnd())
                .build();
    }
}
