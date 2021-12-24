package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.sibsutis.dormitory.server.model.dto.BaseInfoDto;

@Builder
@Data
public class TenantInfoDto {

    @JsonProperty("personal_info")
    private PersonalInfoDto personalInfoDto;

    @JsonProperty("base_info")
    private BaseInfoDto baseInfoDto;

    @JsonProperty("dorm_tenant")
    private DormInfoDto dormDto;

    @JsonProperty("section_tenant")
    private SectionInfoDto sectionDto;

    @JsonProperty("room_tenant")
    private RoomInfoDto roomDto;

}
