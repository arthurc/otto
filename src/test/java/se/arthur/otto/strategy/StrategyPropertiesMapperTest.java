package se.arthur.otto.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.arthur.otto.strategy.example.ExampleStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyPropertiesMapperTest {

    private StrategyPropertiesMapper mapper;

    @BeforeEach
    void setUp() {
        var registration = new StrategyProperties.Registration();
        registration.setClassName(ExampleStrategy.class);

        var properties = new StrategyProperties();
        properties.getRegistration().put("test", registration);

        this.mapper = new StrategyPropertiesMapper(properties);
    }

    @Test
    void getStrategyRegistrations_returns_a_mapped_registration() {
        assertThat(this.mapper.getStrategyRegistrations())
                .extractingByKey("test")
                .isEqualTo(new StrategyRegistration("test", ExampleStrategy.class));
    }
}
