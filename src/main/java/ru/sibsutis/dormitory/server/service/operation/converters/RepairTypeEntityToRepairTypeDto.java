package ru.sibsutis.dormitory.server.service.operation.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomDto;
import ru.sibsutis.dormitory.server.model.dto.operation.response.RepairTypeDto;
import ru.sibsutis.dormitory.server.model.dto.operation.response.RepairTypeInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.RoomEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairTypeEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class RepairTypeEntityToRepairTypeDto implements Converter<Collection<RepairTypeEntity>, RepairTypeDto> {
    @Override
    public RepairTypeDto convert(Collection<RepairTypeEntity> repairTypeEntities) {
        return RepairTypeDto.builder()
                .repairTypeInfoDto(repairTypeEntities.stream()
                        .map(repairTypeEntity -> RepairTypeInfoDto.builder()
                                .baseInfoDto(BaseInfoDto.builder()
                                        .id(repairTypeEntity.getId())
                                        .name(repairTypeEntity.getRepairTypeName())
                                        .build()
                                ).build()
                        ).collect(Collectors.toList())
                ).build();
    }
}
