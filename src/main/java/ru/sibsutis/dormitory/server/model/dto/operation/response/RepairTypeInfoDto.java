package ru.sibsutis.dormitory.server.model.dto.operation.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.sibsutis.dormitory.server.model.dto.BaseInfoDto;

@Builder
@Data
public class RepairTypeInfoDto {

    @JsonProperty("base_info")
    private BaseInfoDto baseInfoDto;

}
