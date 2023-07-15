package se.arthur.otto.strategy;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.PropertyMapper;

import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class StrategyPropertiesMapper {
    private final StrategyProperties properties;

    public Map<String, StrategyRegistration> getStrategyRegistrations() {
        return this.properties.getRegistration().entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> getStrategyRegistration(e.getKey(), e.getValue())));
    }

    private StrategyRegistration getStrategyRegistration(String registrationId, StrategyProperties.Registration registration) {
        var builder = StrategyRegistration.builder().registrationId(registrationId);

        PropertyMapper mapper = PropertyMapper.get().alwaysApplyingWhenNonNull();
        mapper.from(registration::getClassName).to(builder::strategyClass);
        return builder.build();
    }
}
