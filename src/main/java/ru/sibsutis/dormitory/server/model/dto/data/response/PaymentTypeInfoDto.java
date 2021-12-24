package ru.sibsutis.dormitory.server.model.dto.data.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import ru.sibsutis.dormitory.server.model.dto.BaseInfoDto;

@Builder
@Data
public class PaymentTypeInfoDto {

    @JsonProperty("base_info")
    private BaseInfoDto baseInfoDto;

}
