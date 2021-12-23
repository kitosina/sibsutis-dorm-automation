package ru.sibsutis.dormitory.server.service.data;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.sibsutis.dormitory.server.model.dto.data.response.PaymentTypeDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.PaymentTypeInfoDto;
import ru.sibsutis.dormitory.server.repository.data.PaymentTypeRepository;

@RequiredArgsConstructor
@Service
public class PaymentService {

    private final PaymentTypeRepository paymentTypeRepository;
    private final ConversionService conversionService;

    public PaymentTypeDto allPaymentType() {
        return conversionService.convert(paymentTypeRepository.findAll(), PaymentTypeDto.class);
    }

}
