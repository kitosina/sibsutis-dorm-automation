package ru.sibsutis.dormitory.server.service.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibsutis.dormitory.server.model.dto.operation.request.CertificationRequestDto;
import ru.sibsutis.dormitory.server.model.entity.operations.CertificateRequestEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RequestStatusEntity;
import ru.sibsutis.dormitory.server.repository.operation.CertificateRequestRepository;
import ru.sibsutis.dormitory.server.repository.operation.RequestStatusRepository;

@RequiredArgsConstructor
@Service
public class CertificationService {

    private final CertificateRequestRepository certificateRequestRepository;
    private final RequestStatusRepository requestStatusRepository;
    private final ConversionService conversionService;

    @Transactional(rollbackFor = Exception.class)
    public void certificationNewRequest(final CertificationRequestDto certificationRequestDto) {
        CertificateRequestEntity requestEntity =
                conversionService.convert(certificationRequestDto, CertificateRequestEntity.class);

        RequestStatusEntity requestStatusEntity = requestStatusRepository.findByRequestStatusName(
                        RequestStatusEntity.RequestStatusName.PROCESSING.getRequestStatusName())
                .orElseThrow(() -> new RuntimeException(String.format(ErrorMsg.MSG_NOT_FOUND_REQUEST_STATUS.getErrorMsg(),
                        RequestStatusEntity.RequestStatusName.PROCESSING.getRequestStatusName())));

        requestEntity.setRequestStatusEntity(requestStatusEntity);

        certificateRequestRepository.save(requestEntity);
    }

}
