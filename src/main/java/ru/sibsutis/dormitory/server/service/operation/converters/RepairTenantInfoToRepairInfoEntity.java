package ru.sibsutis.dormitory.server.service.operation.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.operation.request.RepairRequestDto;
import ru.sibsutis.dormitory.server.model.dto.operation.response.RepairTypeDto;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairInfoEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairTypeEntity;

import java.util.Collection;

public class RepairTenantInfoToRepairInfoEntity implements Converter<RepairRequestDto.RepairTenantInfo, RepairInfoEntity>  {
    @Override
    public RepairInfoEntity convert(RepairRequestDto.RepairTenantInfo repairTenantInfo) {
        return RepairInfoEntity.builder()
                .dormId(repairTenantInfo.getDormId())
                .numRoom(repairTenantInfo.getRoomNum())
                .sectionName(repairTenantInfo.getSectionName())
                .build();
    }
}
