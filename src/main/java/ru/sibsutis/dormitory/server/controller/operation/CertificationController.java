package ru.sibsutis.dormitory.server.controller.operation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.model.dto.operation.request.CertificationRequestDto;
import ru.sibsutis.dormitory.server.service.operation.CertificationService;
import ru.sibsutis.dormitory.server.service.operation.RepairService;

import static ru.sibsutis.dormitory.server.controller.operation.CertificationController.CERTIFICATION_URL;

@RequiredArgsConstructor
@RequestMapping(CERTIFICATION_URL)
@RestController
public class CertificationController {

    private final CertificationService certificationService;

    public static final String CERTIFICATION_URL = "/certification";
    private static final String CERTIFICATION_NEW_REQUEST_URL = "/request/new";

    @PostMapping(CERTIFICATION_NEW_REQUEST_URL)
    public ResponseEntity certificationNewRequest(@RequestBody final CertificationRequestDto certificationRequestDto) {
        certificationService.certificationNewRequest(certificationRequestDto);
        return ResponseEntity.ok().build();
    }
}
