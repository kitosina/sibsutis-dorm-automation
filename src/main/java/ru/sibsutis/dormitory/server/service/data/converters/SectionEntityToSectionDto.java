package ru.sibsutis.dormitory.server.service.data.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.data.response.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.SectionEntity;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SectionEntityToSectionDto implements Converter<Collection<SectionEntity>, SectionDto>  {

    @Override
    public SectionDto convert(Collection<SectionEntity> sectionEntities) {
        return SectionDto.builder()
                .sectionInfoDto(sectionEntities.stream()
                        .map(sectionEntity -> SectionInfoDto.builder()
                                .baseInfoDto(BaseInfoDto.builder()
                                        .id(sectionEntity.getId())
                                        .name(sectionEntity.getName())
                                        .build())
                                .build()
                        ).collect(Collectors.toList())
                ).build();
    }

}
