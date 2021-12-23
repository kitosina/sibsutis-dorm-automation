package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TenantInfoDto {

    @JsonProperty("dorm")
    private DormDto dormDto;

    @JsonProperty("section")
    private SectionDto sectionDto;

    @JsonProperty("room")
    private RoomDto roomDto;
}
