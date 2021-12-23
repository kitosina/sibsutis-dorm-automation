package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RoomInfoDto {

    @JsonProperty("base_info")
    private BaseInfoDto baseInfoDto;

}
