package ru.sibsutis.dormitory.server.model.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class RepairTypeDto {

    @JsonProperty("repair_type")
    private List<RepairTypeInfoDto> repairTypeInfoDto;

}