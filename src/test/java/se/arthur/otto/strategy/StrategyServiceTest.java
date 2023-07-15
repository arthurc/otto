package se.arthur.otto.strategy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.arthur.otto.strategy.example.ExampleStrategy;

import java.util.List;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
class StrategyServiceTest {
    private static final StrategyRegistration REGISTRATION = new StrategyRegistration("example", ExampleStrategy.class);

    @Autowired
    private StrategyService strategyService;

    @SpyBean
    private ExampleEventListener exampleEventListener;

    @Test
    void deploy_can_deploy_a_strategy() {
        this.strategyService.deploy("example");

        verify(this.exampleEventListener).on(isA(StrategyDeployedEvent.class));
    }

    @Configuration
    static class TestConfig {
        @Bean
        StrategyService strategyService(ApplicationContext applicationContext) {
            return new StrategyService(new StrategyRegistrationRepository(List.of(REGISTRATION)), applicationContext);
        }

        @Bean
        ExampleEventListener exampleEventListener() {
            return new ExampleEventListener();
        }
    }

    static class ExampleEventListener {
        @EventListener
        public void on(StrategyDeployedEvent event) {
        }
    }

}
