package io.github.thesmoothrere.relib.config;

import io.github.thesmoothrere.relib.Constants;
import io.github.thesmoothrere.relib.api.ConfigApi;
import io.github.thesmoothrere.relib.config.option.ConfigOption;
import org.jspecify.annotations.NonNull;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Central registry for configuration instances.
 * <p>
 * ReLib discovers {@link ConfigApi} implementations at startup, registers them
 * here, and provides convenience methods for loading from and saving to disk.
 * </p>
 */
public final class ConfigManager {
    private static final Map<Class<? extends ConfigApi>, ConfigApi> CONFIGS = new HashMap<>();

    private ConfigManager() {
    }

    /**
     * Registers a config instance, then loads its values from disk.
     * <p>
     * If the config class is already registered a warning is logged and
     * registration is skipped.
     * </p>
     *
     * @param <T>            the config type
     * @param configInstance the config instance to register
     */
    public static <T extends ConfigApi> void register(T configInstance) {
        Class<? extends ConfigApi> configClass = configInstance.getClass();
        if (CONFIGS.containsKey(configClass)) {
            Constants.LOGGER.warn("Config class {} is already registered, skipping registration", configClass);
            return;
        }

        load(configInstance);
        CONFIGS.putIfAbsent(configClass, configInstance);
        Constants.LOGGER.info("Registered config class {}", configClass);
    }

    /**
     * Loads config values from the JSON file on disk into the given config object.
     *
     * @param config the config to load
     */
    public static void load(ConfigApi config) {
        getWriter(config).loadConfig();
    }

    /**
     * Saves the current config values to the JSON file on disk.
     *
     * @param config the config to save
     */
    public static void save(ConfigApi config) {
        getWriter(config).saveConfig();
    }

    private static @NonNull ConfigWriter getWriter(ConfigApi config) {
        ConfigWriter writer = new ConfigWriter(config.getConfigName());
        fillWriter(config, writer);
        return writer;
    }

    private static void fillWriter(ConfigApi config, ConfigWriter writer) {
        Arrays.stream(config.getClass().getMethods())
                .filter(m -> ConfigOption.class.isAssignableFrom(m.getReturnType()))
                .filter(m -> m.getParameterCount() == 0)
                .forEach(m -> {
                    try {
                        Object value = m.invoke(config);
                        if (value instanceof ConfigOption<?> option) {
                            writer.addOption(option);
                        }
                    } catch (Exception e) {
                        Constants.LOGGER.error("Failed to read option: {}", m.getName(), e);
                    }
                });
    }

    /**
     * Retrieves a registered config instance by its class.
     *
     * @param <T>         the config type
     * @param configClass the class of the config to retrieve
     * @return the registered config instance
     * @throws IllegalArgumentException if no config is registered for the given class
     */
    @SuppressWarnings("unchecked")
    public static <T extends ConfigApi> T get(Class<T> configClass) {
        ConfigApi config = CONFIGS.get(configClass);
        if (config == null) {
            throw new IllegalArgumentException("No registered config found for class: " + configClass.getName());
        }
        return (T) config;
    }
}
