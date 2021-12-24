package ru.sibsutis.dormitory.server.service.data;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.repository.data.DormRepository;

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
