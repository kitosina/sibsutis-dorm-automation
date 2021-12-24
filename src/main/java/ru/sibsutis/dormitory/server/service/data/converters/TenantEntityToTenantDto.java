package ru.sibsutis.dormitory.server.service.data.converters;

import ru.sibsutis.dormitory.server.model.dto.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.PersonalInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.TenantDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.TenantInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.TenantEntity;

import java.util.List;

public class TenantEntityToTenantDto {

    public TenantInfoDto convertOneTenant(final List<DormInfoDto> dormInfoDto, final List<SectionInfoDto> sectionInfoDto,
                                          final List<RoomInfoDto> roomInfoDto, final TenantEntity tenantEntity) {
        return TenantInfoDto.builder()
                .baseInfoDto(BaseInfoDto.builder()
                        .id(tenantEntity.getId())
                        .name(tenantEntity.getName())
                        .build())
                .personalInfoDto(PersonalInfoDto.builder()
                        .lastName(tenantEntity.getLastName())
                        .patronymic(tenantEntity.getPatronymic())
                        .build())
                .dormDto(dormInfoDto.get(0))
                .sectionDto(sectionInfoDto.get(0))
                .roomDto(roomInfoDto.get(0))
                .build();
    }
}
