package ru.sibsutis.dormitory.server.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BaseInfoDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

}
