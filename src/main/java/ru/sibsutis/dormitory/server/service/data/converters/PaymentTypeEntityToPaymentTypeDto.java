package ru.sibsutis.dormitory.server.service.data.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.data.response.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.PaymentTypeDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.PaymentTypeInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.RoomInfoDto;
import ru.sibsutis.dormitory.server.model.entity.data.PaymentTypeEntity;

import java.util.Collection;
import java.util.stream.Collectors;

public class PaymentTypeEntityToPaymentTypeDto implements Converter<Collection<PaymentTypeEntity>, PaymentTypeDto> {

    @Override
    public PaymentTypeDto convert(Collection<PaymentTypeEntity> paymentTypeEntities) {
        return PaymentTypeDto.builder()
                .paymentTypeInfoDto(paymentTypeEntities.stream()
                        .map(paymentTypeEntity -> PaymentTypeInfoDto.builder()
                                .baseInfoDto(BaseInfoDto.builder()
                                        .id(paymentTypeEntity.getId())
                                        .name(paymentTypeEntity.getNameType())
                                        .build()
                                ).build()
                        ).collect(Collectors.toList())
                ).build();
    }
}
