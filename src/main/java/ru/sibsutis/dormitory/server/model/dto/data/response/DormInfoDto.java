package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DormInfoDto {

    @JsonProperty("living_space")
    private double livingSpace;

    @JsonProperty("count_room")
    private int countRoom;

    @JsonProperty("base_info")
    private BaseInfoDto baseInfoDto;

}
