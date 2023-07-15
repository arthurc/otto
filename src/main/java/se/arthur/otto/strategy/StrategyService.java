package se.arthur.otto.strategy;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class StrategyService {
    private final StrategyRegistrationRepository strategyRegistrations;
    private final ApplicationContext applicationContext;

    public void deploy(String strategyId) {
        var registration = this.strategyRegistrations.findByRegistrationId(strategyId);

        var strategyContext = new StaticApplicationContext(this.applicationContext);
        strategyContext.registerBean("strategy." + registration.getRegistrationId(), registration.getStrategyClass());
        strategyContext.refresh();
        strategyContext.start();

        this.applicationContext.publishEvent(new StrategyDeployedEvent(strategyContext, registration.getRegistrationId()));

        log.info("Deployed strategy [{}]", registration);
    }

}
