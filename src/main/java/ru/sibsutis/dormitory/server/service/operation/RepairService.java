package ru.sibsutis.dormitory.server.service.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibsutis.dormitory.server.model.dto.operation.request.RepairRequestDto;
import ru.sibsutis.dormitory.server.model.dto.operation.response.RepairTypeDto;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairInfoEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairRequestEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RepairTypeEntity;
import ru.sibsutis.dormitory.server.model.entity.operations.RequestStatusEntity;
import ru.sibsutis.dormitory.server.repository.operation.RepairInfoRepository;
import ru.sibsutis.dormitory.server.repository.operation.RepairRequestRepository;
import ru.sibsutis.dormitory.server.repository.operation.RepairTypeRepository;
import ru.sibsutis.dormitory.server.repository.operation.RequestStatusRepository;

@RequiredArgsConstructor
@Service
public class RepairService {

    private final RepairTypeRepository repairTypeRepository;
    private final RepairInfoRepository repairInfoRepository;
    private final RepairRequestRepository repairRequestRepository;
    private final RequestStatusRepository requestStatusRepository;
    private final ConversionService conversionService;

    public RepairTypeDto allTypeRepair() {
        return conversionService.convert(repairTypeRepository.findAll(), RepairTypeDto.class);
    }

    @Transactional(rollbackFor = Exception.class)
    public void repairNewRequest(final RepairRequestDto repairRequestDto) {
        var repairRequest = RepairRequestEntity.builder();

        var repairTenantInfo = repairRequestDto.getRepairTenantInfo();
        RepairInfoEntity infoEntity = conversionService.convert(repairTenantInfo, RepairInfoEntity.class);
        assert infoEntity != null;

        var repairInfoEntity = repairInfoRepository.findByNumRoomAndSectionNameAndDormId(repairTenantInfo.getRoomNum(),
                repairTenantInfo.getSectionName(), repairTenantInfo.getDormId());

        if (repairInfoEntity.isEmpty()) {
            repairRequest.repairInfoEntity(repairInfoRepository.save(infoEntity));
        } else {
            repairRequest.repairInfoEntity(repairInfoEntity.get());
        }

        RepairTypeEntity repairTypeEntity = repairTypeRepository.findById(repairRequestDto.getRepairTypeId())
                .orElseThrow(() -> new RuntimeException(String.format(ErrorMsg.MSG_NOT_FOUND_REPAIR_TYPE.getErrorMsg(),
                        repairRequestDto.getRepairTypeId())));
        repairRequest.repairTypeEntity(repairTypeEntity);

        RequestStatusEntity requestStatusEntity = requestStatusRepository.findByRequestStatusName(
                RequestStatusEntity.RequestStatusName.PROCESSING.getRequestStatusName())
                .orElseThrow(() -> new RuntimeException(String.format(ErrorMsg.MSG_NOT_FOUND_REQUEST_STATUS.getErrorMsg(),
                        RequestStatusEntity.RequestStatusName.PROCESSING.getRequestStatusName())));
        repairRequest.requestStatusEntity(requestStatusEntity);
        repairRequest.comment(repairRequestDto.getComment());

        repairRequestRepository.save(repairRequest.build());
    }

}
