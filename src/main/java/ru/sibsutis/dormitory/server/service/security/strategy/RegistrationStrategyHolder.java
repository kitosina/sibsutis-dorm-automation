package ru.sibsutis.dormitory.server.service.security.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class RegistrationStrategyHolder {

    private final Map<String, RegistrationStrategy> registrationStrategyMap;

    private static final String MSG_ERROR_NOT_FOUND_STRATEGY =
            "Не найдена стратегия для регистрации пользователя типа: %s";

    public RegistrationStrategy getStrategy(final String strategyType) {
        RegistrationStrategy registrationStrategy = registrationStrategyMap.get(strategyType);
        if (registrationStrategy == null) {
            throw new RuntimeException(String.format(MSG_ERROR_NOT_FOUND_STRATEGY, strategyType));
        }
        return registrationStrategy;
    }
}
