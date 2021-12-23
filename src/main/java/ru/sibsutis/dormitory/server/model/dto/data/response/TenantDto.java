package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class TenantDto {

    @JsonProperty("tenant")
    private List<TenantInfoDto> tenantInfoDto;

}
