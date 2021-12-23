package ru.sibsutis.dormitory.server.model.dto.security.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

/**
 * dto для заведения студента в систему
 */
@Data
public class UserInfoDto {

    @JsonProperty("user_basic_info")
    private UserBasicInfoDto userBasicInfoDto;

    @JsonProperty("name")
    private String name;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("payment_type_id")
    private int paymentTypeId;

    @JsonProperty("dorm_id")
    private int dormId;

    @JsonProperty("room_id")
    private int roomId;

    @JsonProperty("passport")
    private String passport;

    @JsonProperty("birth_date")
    private LocalDate birthDate;

    @JsonProperty("contract_begin")
    private LocalDate contractBegin;

    @JsonProperty("contract_end")
    private LocalDate contractEnd;

    @JsonProperty("registration_strategy")
    private String strategyRegistration;
}
