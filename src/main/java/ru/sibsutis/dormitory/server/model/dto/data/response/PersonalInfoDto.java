package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class PersonalInfoDto {

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("patronymic")
    private String patronymic;
}
