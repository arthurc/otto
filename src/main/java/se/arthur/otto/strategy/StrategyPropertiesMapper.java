package se.arthur.otto.strategy;

import java.util.Map;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class StrategyPropertiesMapper {
    private final StrategyProperties properties;

    public Map<String, StrategyRegistration> getStrategyRegistrations() {
        throw new UnsupportedOperationException("Unimplemented method");
    }
}
