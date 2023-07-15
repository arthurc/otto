package se.arthur.otto.strategy;

import java.util.Iterator;

public class StrategyRegistrationRepository implements Iterable<StrategyRegistration> {
    public StrategyRegistration findByRegistrationId(String registrationId) {
        throw new UnsupportedOperationException("Unimplemented method");        
    }

    @Override
    public Iterator<StrategyRegistration> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
}
