package kz.iitu.spring_lab_01.config;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class EnvironmentBanner {
    private final Environment environment;

    public EnvironmentBanner(Environment environment) {
        this.environment = environment;
    }

    public String describe() {
        String[] profiles = environment.getActiveProfiles();
        if (profiles.length == 0) {
            return "Default environment";
        }
        return "Active profiles: " + String.join(", ", profiles);
    }
}