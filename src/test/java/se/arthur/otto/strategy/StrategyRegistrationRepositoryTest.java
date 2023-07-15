package se.arthur.otto.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.arthur.otto.strategy.example.ExampleStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class StrategyRegistrationRepositoryTest {

    private final StrategyRegistration registration = new StrategyRegistration("example", ExampleStrategy.class);

    private StrategyRegistrationRepository strategyRegistrationRepository;

    @BeforeEach
    void setUp() {
        this.strategyRegistrationRepository = new StrategyRegistrationRepository(this.registration);
    }

    @Test
    void findByRegistrationId_should_find_a_registration_matching_the_id() {
        assertThat(this.strategyRegistrationRepository.findByRegistrationId("example")).isEqualTo(this.registration);
    }

    @Test
    void findByRegistrationId_should_return_null_if_no_registration_is_found() {
        assertThat(this.strategyRegistrationRepository.findByRegistrationId("doesnotexist")).isNull();
    }

    @Test
    void iterator_should_iterate_the_registrations() {
        assertThat(this.strategyRegistrationRepository.iterator()).toIterable().containsExactly(this.registration);
    }

}