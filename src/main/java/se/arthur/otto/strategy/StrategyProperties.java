package se.arthur.otto.strategy;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@Configuration
@ConfigurationProperties("otto.strategy")
@Data
class StrategyProperties {
    private final Map<String, Registration> registration = new LinkedHashMap<>();

    @Data
    static class Registration implements InitializingBean {
        private Class<? extends Strategy> className;

        @Override
        public void afterPropertiesSet() {
            validate();
        }

        private void validate() {
            Objects.requireNonNull(this.className, "Class name cannot be empty");
        }
    }
}
