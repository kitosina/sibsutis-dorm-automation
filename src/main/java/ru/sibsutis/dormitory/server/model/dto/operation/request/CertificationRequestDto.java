package ru.sibsutis.dormitory.server.model.dto.operation.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CertificationRequestDto {

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("tenant_id")
    private int tenantId;

}
