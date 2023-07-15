package se.arthur.otto.strategy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class StrategyRegistrationRepository implements Iterable<StrategyRegistration> {
    private final Map<String, StrategyRegistration> registrations;

    private StrategyRegistrationRepository(Map<String, StrategyRegistration> registrations) {
        this.registrations = Objects.requireNonNull(registrations);
    }

    public StrategyRegistrationRepository(Collection<StrategyRegistration> registrations) {
        this(registrations.stream().collect(Collectors.toMap(StrategyRegistration::getRegistrationId, Function.identity())));
    }

    public StrategyRegistrationRepository(StrategyRegistration... registrations) {
        this(List.of(registrations));
    }

    public StrategyRegistration findByRegistrationId(String registrationId) {
        return this.registrations.get(registrationId);
    }

    @Override
    public Iterator<StrategyRegistration> iterator() {
        return this.registrations.values().iterator();
    }
}
