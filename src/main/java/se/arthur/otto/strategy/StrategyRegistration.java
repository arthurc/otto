package se.arthur.otto.strategy;

import lombok.*;

@Getter
@RequiredArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
class StrategyRegistration {
    private final String registrationId;
    private final Class<? extends Strategy> strategyClass;
}
