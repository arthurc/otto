package se.arthur.otto.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
class StrategyModuleConfiguration {
    private final StrategyProperties properties;

    @Bean
    StrategyRegistrationRepository strategyRegistrationRepository() {
        StrategyPropertiesMapper strategyPropertiesMapper = new StrategyPropertiesMapper(this.properties);
        return new StrategyRegistrationRepository(strategyPropertiesMapper.getStrategyRegistrations().values());
    }

}
