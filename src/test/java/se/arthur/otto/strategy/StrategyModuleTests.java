package se.arthur.otto.strategy;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.event.EventListener;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.TestPropertySource;
import se.arthur.otto.strategy.example.ExampleStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

@ApplicationModuleTest
@TestPropertySource(properties = "otto.strategy.registration.example.class-name: se.arthur.otto.strategy.example.ExampleStrategy")
class StrategyModuleTests {

    @SpyBean
    private ExampleEventListener exampleEventListener;

    @Test
    void it_deploys_a_strategy_on_startup() {
        var captor = ArgumentCaptor.forClass(StrategyDeployedEvent.class);

        verify(this.exampleEventListener, atLeastOnce()).on(captor.capture());

        var event = captor.getValue();
        assertThat(event.strategyId()).isEqualTo("example");
        assertThat(event.applicationContext().getBean("strategy.example")).isInstanceOf(ExampleStrategy.class);
    }

    static class ExampleEventListener {
        @EventListener
        public void on(StrategyDeployedEvent event) {
            System.out.println("YUPYUP");
        }
    }

}
