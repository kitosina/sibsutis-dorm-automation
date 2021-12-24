package ru.sibsutis.dormitory.server.service.data;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.TenantDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.TenantInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.DormEntity;
import ru.sibsutis.dormitory.server.model.entity.data.RoomEntity;
import ru.sibsutis.dormitory.server.model.entity.data.SectionEntity;
import ru.sibsutis.dormitory.server.model.entity.data.TenantEntity;
import ru.sibsutis.dormitory.server.repository.data.RoomRepository;
import ru.sibsutis.dormitory.server.repository.data.SectionRepository;
import ru.sibsutis.dormitory.server.repository.data.TenantRepository;
import ru.sibsutis.dormitory.server.service.data.converters.TenantEntityToTenantDto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TenantService {

    private final TenantRepository tenantRepository;
    private final SectionRepository sectionRepository;
    private final RoomRepository roomRepository;
    private final ConversionService conversionService;

    private static final String MSG_NOT_AUTH_USER = "Ошибка авторизованного пользователя";
    private static final String MSG_NOT_FOUND_TENANT = "Не найден жилец с email: %s";
    private static final String MSG_NOT_FOUND_ROOM = "Не найдена комната для жильца с ФИО: %s %s %s";
    private static final String MSG_NOT_FOUND_SECTION = "Не найдена секция для комнаты: %s";
    private static final String MSG_NOT_FOUND_DORM = "Не найдено общежитие для секции: %s с id: %d";

    public TenantDto tenantInfoAuth(final User user) {
        String emailUser;
        if (user == null) {
            throw new RuntimeException(MSG_NOT_AUTH_USER);
        } else {
            emailUser = user.getUsername();
            TenantEntity tenantEntity = tenantRepository.findByEmail(emailUser)
                    .orElseThrow(() -> new RuntimeException(String.format(MSG_NOT_FOUND_TENANT, user)));

            RoomEntity roomEntity = roomRepository.findByTenantEntities(tenantEntity.getId())
                    .orElseThrow(() -> new RuntimeException(String.format(MSG_NOT_FOUND_ROOM,
                            tenantEntity.getName(), tenantEntity.getLastName(), tenantEntity.getPatronymic())));

            SectionEntity sectionEntity = sectionRepository.findByRoomEntities(roomEntity.getId())
                    .orElseThrow(() -> new RuntimeException(String.format(MSG_NOT_FOUND_SECTION, roomEntity.getNumRoom())));

            DormEntity dormEntity = Optional.of(sectionEntity.getDormEntity())
                    .orElseThrow(() -> new RuntimeException(String.format(MSG_NOT_FOUND_DORM,
                            sectionEntity.getName(), sectionEntity.getId())));

            TenantEntityToTenantDto converter = new TenantEntityToTenantDto();
            List<TenantInfoDto> tenantInfoDto = List.of(converter.convertOneTenant(
                    conversionService.convert(Collections.singleton(dormEntity), DormDto.class).getDormInfoDto(), // DormDto
                    conversionService.convert(Collections.singleton(sectionEntity), SectionDto.class).getSectionInfoDto(), // SectionDto
                    conversionService.convert(Collections.singleton(roomEntity), RoomDto.class).getRoomInfoDto(), // RoomDto
                    tenantEntity)
            );

            return TenantDto.builder()
                    .tenantInfoDto(tenantInfoDto)
                    .build();
        }
    }

}
