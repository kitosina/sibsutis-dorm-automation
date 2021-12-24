package ru.sibsutis.dormitory.server.model.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RepairRequestDto {

    @JsonProperty("repair_type_id")
    private long repairTypeId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("repair_info")
    private RepairTenantInfo repairTenantInfo;

    @Data
    public static class RepairTenantInfo {

        @JsonProperty("tenant_id")
        private int tenantId;

        @JsonProperty("tenant_room_num")
        private int roomNum;

        @JsonProperty("tenant_section_name")
        private String sectionName;

        @JsonProperty("dorm_id")
        private int dormId;

    }

}
