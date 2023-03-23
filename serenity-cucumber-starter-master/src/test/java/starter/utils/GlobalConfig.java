package starter.utils;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;

import static net.serenitybdd.core.environment.ConfiguredEnvironment.getEnvironmentVariables;

public class GlobalConfig {
    public static final String GOOGLE_HOME = EnvironmentSpecificConfiguration.from(getEnvironmentVariables()).getProperty("webdriver.base.url");
}