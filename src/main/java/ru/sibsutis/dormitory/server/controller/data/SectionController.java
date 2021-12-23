package ru.sibsutis.dormitory.server.controller.data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.service.data.SectionService;

import static ru.sibsutis.dormitory.server.controller.data.SectionController.SECTION_URL;

@RequiredArgsConstructor
@RequestMapping(SECTION_URL)
@RestController
public class SectionController {

    private final SectionService sectionService;

    public static final String SECTION_URL = "/section";

    /**
     * Получение списка всех секция (коридоров) для общежития
     * @param dormId идентификатор общежития
     * @return информация о секциях
     */
    @GetMapping
    public ResponseEntity allSectionDorm(@RequestParam("dorm_id") final long dormId) {
        return ResponseEntity.ok(sectionService.allSectionDorm(dormId));
    }

}
