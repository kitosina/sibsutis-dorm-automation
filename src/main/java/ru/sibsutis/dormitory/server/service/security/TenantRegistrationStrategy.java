package ru.sibsutis.dormitory.server.service.security;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.sibsutis.dormitory.server.model.dto.security.request.UserInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.PaymentTypeEntity;
import ru.sibsutis.dormitory.server.model.entity.data.RoomEntity;
import ru.sibsutis.dormitory.server.model.entity.data.TenantEntity;
import ru.sibsutis.dormitory.server.model.entity.security.Role;
import ru.sibsutis.dormitory.server.repository.data.PaymentTypeRepository;
import ru.sibsutis.dormitory.server.repository.data.RoomRepository;
import ru.sibsutis.dormitory.server.repository.data.TenantRepository;
import ru.sibsutis.dormitory.server.service.security.strategy.RegistrationStrategy;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;

@RequiredArgsConstructor
@Component("tenant")
public class TenantRegistrationStrategy implements RegistrationStrategy {

    private final TenantRepository tenantRepository;
    private final RoomRepository roomRepository;
    private final PaymentTypeRepository paymentTypeRepository;
    private final ConversionService conversionService;

    /**
     * Права для пользователя
     */
    private final Role role = Role.TENANT;

    private static final String MSG_ERROR = "Ошибка поиска % с id %s";

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void registrationUser(final MultipartFile documentScanOne, final MultipartFile documentScanTwo,
                                    final UserInfoDto userInfoDto) {
        // Находим информацию о комнате для проживания
        RoomEntity roomEntity = roomRepository.findById(userInfoDto.getRoomId())
                .orElseThrow(() -> new RuntimeException(String.format(MSG_ERROR, "комнаты",
                        userInfoDto.getRoomId())));

        // Находим информацию о типе оплаты
        PaymentTypeEntity paymentTypeEntity = paymentTypeRepository.findById(userInfoDto.getPaymentTypeId())
                .orElseThrow(() -> new RuntimeException(String.format(MSG_ERROR, "типа оплаты",
                        userInfoDto.getPaymentTypeId())));

        // Сохраняем информацию о проживающем
        TenantEntity tenantEntity = conversionService.convert(userInfoDto, TenantEntity.class);
        // FIXME: нормальная обработка исключений
        try {
            tenantEntity.setPassportScan(documentScanOne.getBytes());
            tenantEntity.setRegScan(documentScanTwo.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tenantEntity.setRoomEntity(roomEntity);
        tenantEntity.setPaymentTypeEntity(paymentTypeEntity);
        tenantRepository.save(tenantEntity);
    }

    @Override
    public Set<Role> getRegistrationRoleUser() {
        return Collections.singleton(role);
    }

    @Override
    public void validate(final UserInfoDto userInfoDto) {

    }

}
