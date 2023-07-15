package se.arthur.otto.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
class StrategyModuleInitializer implements ApplicationModuleInitializer {
    private final StrategyRegistrationRepository strategyRegistrations;
    private final StrategyService strategyService;

    @Override
    public void initialize() {
        for (StrategyRegistration registration : this.strategyRegistrations) {
            this.strategyService.deploy(registration.getRegistrationId());
        }
    }
}
