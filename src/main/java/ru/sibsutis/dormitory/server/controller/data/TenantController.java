package ru.sibsutis.dormitory.server.controller.data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.service.data.TenantService;

import static ru.sibsutis.dormitory.server.controller.data.TenantController.URL_TENANT;

@RequiredArgsConstructor
@RequestMapping(URL_TENANT)
@RestController
public class TenantController {

    private final TenantService tenantService;

    public static final String URL_TENANT = "/tenant";

    @GetMapping
    public ResponseEntity tenantInfo(@RequestParam("user_email") final String userAuth) {
        return ResponseEntity.ok(tenantService.tenantInfo(userAuth));
    }

}
