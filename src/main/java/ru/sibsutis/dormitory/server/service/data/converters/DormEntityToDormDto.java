package ru.sibsutis.dormitory.server.service.data.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.DormEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class DormEntityToDormDto implements Converter<Collection<DormEntity>, DormDto> {

    @Override
    public DormDto convert(Collection<DormEntity> dormEntities) {
        return DormDto.builder()
                .dormInfoDto(dormEntities.stream()
                        .map(dormEntity -> DormInfoDto.builder()
                                .countRoom(dormEntity.getCountRoom())
                                .livingSpace(dormEntity.getLivingSpace())
                                .baseInfoDto(BaseInfoDto.builder()
                                        .id(dormEntity.getId())
                                        .name(dormEntity.getName())
                                        .build())
                                .build())
                        .collect(Collectors.toList())
                ).build();
    }
}
