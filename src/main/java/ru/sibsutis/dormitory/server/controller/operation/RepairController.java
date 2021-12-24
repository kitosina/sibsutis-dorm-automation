package ru.sibsutis.dormitory.server.controller.operation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.model.dto.operation.request.RepairRequestDto;
import ru.sibsutis.dormitory.server.service.operation.RepairService;

import static ru.sibsutis.dormitory.server.controller.operation.RepairController.REPAIR_URL;

@RequiredArgsConstructor
@RequestMapping(REPAIR_URL)
@RestController
@Slf4j
public class RepairController {

    private final RepairService repairService;

    public static final String REPAIR_URL = "/repair";
    private static final String REPAIR_TYPE_URL = "/types";
    private static final String REPAIR_NEW_REQUEST_URL = "/request/new";

    @GetMapping(REPAIR_TYPE_URL)
    public ResponseEntity allTypeRepair() {
        return ResponseEntity.ok(repairService.allTypeRepair());
    }

    @PostMapping(REPAIR_NEW_REQUEST_URL)
    public ResponseEntity repairNewRequest(@RequestBody final RepairRequestDto repairRequestDto) {
        repairService.repairNewRequest(repairRequestDto);
        return ResponseEntity.ok().build();
    }

}
