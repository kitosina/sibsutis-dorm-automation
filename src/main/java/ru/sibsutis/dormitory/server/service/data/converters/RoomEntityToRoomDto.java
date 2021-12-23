package ru.sibsutis.dormitory.server.service.data.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.data.response.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.RoomEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class RoomEntityToRoomDto implements Converter<Collection<RoomEntity>, RoomDto> {

    @Override
    public RoomDto convert(Collection<RoomEntity> roomEntities) {
        return RoomDto.builder()
                .roomInfoDto(roomEntities.stream()
                        .map(roomEntity -> RoomInfoDto.builder()
                                .baseInfoDto(BaseInfoDto.builder()
                                        .id(roomEntity.getId())
                                        .name(String.valueOf(roomEntity.getNumRoom()))
                                        .build()
                                ).build()
                        ).collect(Collectors.toList())
                ).build();
    }

}
