package ru.sibsutis.dormitory.server.controller.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ru.sibsutis.dormitory.server.controller.operation.RepairController.REPAIR_URL;

@RequiredArgsConstructor
@RequestMapping(REPAIR_URL)
@RestController
public class RepairController {

    public static final String REPAIR_URL = "/repair";

}
