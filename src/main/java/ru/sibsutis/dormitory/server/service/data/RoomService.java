package ru.sibsutis.dormitory.server.service.data;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomDto;
import ru.sibsutis.dormitory.server.repository.data.RoomRepository;


@RequiredArgsConstructor
@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final ConversionService conversionService;

    public RoomDto allRoomSection(final long sectionId) {
        return conversionService.convert(roomRepository.findAllFreeRoomBySectionId(sectionId), RoomDto.class);
    }
}
