package com.mjc.stage2.loaders;

import lombok.SneakyThrows;
import org.apache.commons.configuration.PropertiesConfiguration;

public class H2DatabasePropertiesLoader implements PropertiesLoader {
    private static class H2DatabasePropertiesLoaderHolder {
        private static final PropertiesConfiguration configuration = new PropertiesConfiguration();

        private static final H2DatabasePropertiesLoader instance = new H2DatabasePropertiesLoader(H2DatabasePropertiesLoaderHolder.configuration);
    }

    private final PropertiesConfiguration configuration;
    private static final String FILENAME = "h2database.properties";

    public static H2DatabasePropertiesLoader getInstance() {
        return H2DatabasePropertiesLoaderHolder.instance;
    }

    @SneakyThrows
    private H2DatabasePropertiesLoader(PropertiesConfiguration configuration) {
        configuration.load(FILENAME);
        this.configuration = configuration;
    }

    @Override
    public String getByKey(String key) {
        return this.configuration.getString(key);
    }
}
