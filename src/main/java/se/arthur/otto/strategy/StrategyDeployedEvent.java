package se.arthur.otto.strategy;

import org.springframework.context.ApplicationContext;

public record StrategyDeployedEvent(ApplicationContext applicationContext, String strategyId) {
}
