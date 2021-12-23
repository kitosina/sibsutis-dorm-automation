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

    public List<TenantInfoDto> tenantInfo(final String user) {
//        String emailUser;
//        if (user == null) {
//            throw new RuntimeException(MSG_NOT_AUTH_USER);
//        } else {
//            emailUser = user.getUsername();
//        }
        TenantEntity byEmail = tenantRepository.findByEmail(user)
                .orElseThrow(() -> new RuntimeException());
        RoomEntity roomEntity = roomRepository.findByTenantEntities(byEmail.getId()).orElseThrow(() -> new RuntimeException());
        SectionEntity sectionEntity = sectionRepository.findByRoomEntities(roomEntity.getId())
                .orElseThrow(() -> new RuntimeException());

        DormEntity dormEntity = sectionEntity.getDormEntity();
        List<TenantInfoDto> tenantInfoDtos = new ArrayList<>();
        TenantInfoDto tenantInfoDto = TenantInfoDto.builder()
                .dormDto(conversionService.convert(Collections.singleton(dormEntity), DormDto.class))
                .sectionDto(conversionService.convert(Collections.singleton(sectionEntity), SectionDto.class))
                .roomDto(conversionService.convert(Collections.singleton(roomEntity), RoomDto.class))
                .build();
        tenantInfoDtos.add(tenantInfoDto);

        return tenantInfoDtos;
    }

}
