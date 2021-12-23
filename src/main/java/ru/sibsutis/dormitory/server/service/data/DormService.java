package ru.sibsutis.dormitory.server.service.data;

import liquibase.pro.packaged.B;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibsutis.dormitory.server.model.dto.data.response.BaseInfoDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionDto;
import ru.sibsutis.dormitory.server.model.entity.data.DormEntity;
import ru.sibsutis.dormitory.server.model.entity.data.SectionEntity;
import ru.sibsutis.dormitory.server.repository.data.DormRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DormService {

    private final DormRepository dormRepository;
    private final ConversionService conversionService;

    public DormDto allDorm() {
        return conversionService.convert(dormRepository.findAll(), DormDto.class);
    }

}
