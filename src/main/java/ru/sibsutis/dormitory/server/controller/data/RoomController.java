package ru.sibsutis.dormitory.server.controller.data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.service.data.RoomService;

import static ru.sibsutis.dormitory.server.controller.data.RoomController.ROOM_URL;

@RequiredArgsConstructor
@RequestMapping(ROOM_URL)
@RestController
public class RoomController {

    private final RoomService roomService;

    public static final String ROOM_URL = "/room";

    /**
     * Получение списка всех свободных комнат для секции
     * @param sectionId идентификатор секции
     * @return информация о комнатах
     */
    @GetMapping
    public ResponseEntity allRoomSection(@RequestParam("section_id") final long sectionId) {
        return ResponseEntity.ok(roomService.allRoomSection(sectionId));
    }
}
