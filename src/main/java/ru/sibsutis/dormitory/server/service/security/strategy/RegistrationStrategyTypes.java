package ru.sibsutis.dormitory.server.service.security.strategy;

import lombok.Getter;

@Getter
public enum RegistrationStrategyTypes {
    TENANT("tenant");

    private String strategyType;

    RegistrationStrategyTypes(String strategyType) {
        this.strategyType = strategyType;
    }
}
