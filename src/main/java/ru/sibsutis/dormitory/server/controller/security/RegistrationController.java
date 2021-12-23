package ru.sibsutis.dormitory.server.controller.security;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.sibsutis.dormitory.server.model.dto.security.request.UserInfoDto;
import ru.sibsutis.dormitory.server.service.security.UserService;

import static ru.sibsutis.dormitory.server.controller.security.RegistrationController.REGISTRATION_URL;

@RequiredArgsConstructor
@RequestMapping(REGISTRATION_URL)
@RestController
public class RegistrationController {

    private final UserService userService;
    public static final String REGISTRATION_URL = "/registration";

    @PostMapping(consumes = {"multipart/form-data"})
    public void registrationUser(
            @RequestPart("document_scan_one") MultipartFile documentScanOne,
            @RequestPart("document_scan_two") MultipartFile documentScanTwo,
            @RequestPart("registration_info") UserInfoDto userInfoDto) {
        userService.registrationUser(documentScanOne, documentScanTwo, userInfoDto);
    }

}
