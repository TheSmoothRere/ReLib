package io.github.thesmoothrere.relib.api;

/**
 * Interface that all ReLib configuration classes must implement.
 * <p>
 * Implementations should be annotated with {@link Config @Config} and expose
 * configuration options via public no-argument methods that return
 * {@link io.github.thesmoothrere.relib.config.option.ConfigOption ConfigOption<?>}.
 * </p>
 */
public interface ConfigApi {
    /**
     * Returns the config file name read from the {@link Config @Config} annotation.
     *
     * @return the config file name
     */
    default String getConfigName() {
        return getAnnotation().name();
    }

    /**
     * Returns the {@link Config @Config} annotation present on this class.
     *
     * @return the annotation instance
     * @throws IllegalStateException if the class is not annotated with {@code @Config}
     */
    default Config getAnnotation() {
        Class<? extends ConfigApi> clazz = this.getClass();
        Config annotation = clazz.getAnnotation(Config.class);
        if (annotation == null)
            throw new IllegalStateException("Config class " + clazz.getName() + " is missing @Config annotation");
        return annotation;
    }
}
