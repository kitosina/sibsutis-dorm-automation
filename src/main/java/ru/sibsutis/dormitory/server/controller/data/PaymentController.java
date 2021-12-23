package ru.sibsutis.dormitory.server.controller.data;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sibsutis.dormitory.server.model.dto.data.response.DormDto;
import ru.sibsutis.dormitory.server.service.data.DormService;
import ru.sibsutis.dormitory.server.service.data.PaymentService;

import static ru.sibsutis.dormitory.server.controller.data.PaymentController.PAYMENT_URL;


@RequiredArgsConstructor
@RequestMapping(PAYMENT_URL)
@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public static final String PAYMENT_URL = "/payment";
    public static final String PAYMENT_TYPE_URL = "/types";

    /**
     * Получение списка всех типов оплаты
     * @return
     */
    @GetMapping(PAYMENT_TYPE_URL)
    public ResponseEntity allPaymentType() {
        return ResponseEntity.ok(paymentService.allPaymentType());
    }

}
