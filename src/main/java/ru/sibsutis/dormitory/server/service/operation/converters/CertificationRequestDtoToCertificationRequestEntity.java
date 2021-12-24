package ru.sibsutis.dormitory.server.service.operation.converters;

import org.springframework.core.convert.converter.Converter;
import ru.sibsutis.dormitory.server.model.dto.operation.request.CertificationRequestDto;
import ru.sibsutis.dormitory.server.model.dto.operation.request.RepairRequestDto;
import ru.sibsutis.dormitory.server.model.entity.operations.CertificateRequestEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairInfoEntity;

public class CertificationRequestDtoToCertificationRequestEntity
        implements Converter<CertificationRequestDto, CertificateRequestEntity> {

    @Override
    public CertificateRequestEntity convert(CertificationRequestDto certificationRequestDto) {
        return CertificateRequestEntity.builder()
                .comment(certificationRequestDto.getComment())
                .quantity(certificationRequestDto.getQuantity())
                .tenantId(certificationRequestDto.getTenantId())
                .build();
    }

}
