package ru.sibsutis.dormitory.server.service.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMsg {
    MSG_NOT_FOUND_REPAIR_TYPE("Не удалось найти тип ремонта с id: %d"),
    MSG_NOT_FOUND_REQUEST_STATUS("Не удалось найти тип статуса: %s");

    private String errorMsg;
}
