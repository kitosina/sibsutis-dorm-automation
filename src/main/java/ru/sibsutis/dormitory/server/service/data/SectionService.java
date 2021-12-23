package ru.sibsutis.dormitory.server.service.data;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sibsutis.dormitory.server.model.dto.data.response.SectionDto;
import ru.sibsutis.dormitory.server.model.entity.data.SectionEntity;
import ru.sibsutis.dormitory.server.repository.data.SectionRepository;

import java.util.List;


@RequiredArgsConstructor
@Service
public class SectionService {

    private final SectionRepository sectionRepository;
    private final ConversionService conversionService;

    public SectionDto allSectionDorm(final long dormId) {
        return conversionService.convert(sectionRepository.findAllSectionByDormId(dormId),
                SectionDto.class);
    }

}
