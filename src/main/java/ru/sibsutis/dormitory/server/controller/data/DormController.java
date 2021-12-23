package ru.sibsutis.dormitory.server.controller.data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.service.data.DormService;
import ru.sibsutis.dormitory.server.service.security.UserService;

import static ru.sibsutis.dormitory.server.controller.data.DormController.DORM_URL;

@RequiredArgsConstructor
@RequestMapping(DORM_URL)
@RestController
public class DormController {

    private final DormService dormService;

    public static final String DORM_URL = "/dorm";
    public static final String DORM_USER_URL = "/user";

    /**
     * Получение списка всех общежитий
     * @return
     */
    @GetMapping
    public ResponseEntity allDorm() {
        return ResponseEntity.ok(dormService.allDorm());
    }

}
