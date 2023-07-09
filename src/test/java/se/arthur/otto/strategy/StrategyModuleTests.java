package se.arthur.otto.strategy;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
class StrategyModuleTests {

    @Autowired
    private StrategyService strategyService;

    @Test
    void strategyService_can_deploy_a_strategy() {
        
    }
}
