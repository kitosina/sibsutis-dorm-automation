package ru.sibsutis.dormitory.server.model.dto.registration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * dto для заведения студента в систему
 */
@Data
public class StudentRegistration {

    @JsonProperty("name")
    private String studentName;

    @JsonProperty("last_name")
    private String studentLastName;

    @JsonProperty("patronymic")
    private String studentPatronymic;

    @JsonProperty("payment_type")
    private int studentPaymentType;

    @JsonProperty("dorm_number")
    private int studentDormNumber;

    @JsonProperty("section")
    private int studentSection;

    @JsonProperty("room_number")
    private int studentRoomNumber;

    //Валидация
    @JsonProperty("user_info")
    private UserRegistration userRegistration;
}
