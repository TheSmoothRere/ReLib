package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import org.jspecify.annotations.NonNull;

/**
 * Base class for all typed configuration options.
 * <p>
 * Each option has a unique key within its config file, a current value,
 * and a default value. Value and default are initialised to the same
 * value at construction time.
 * </p>
 *
 * @param <T> the type of the option value
 */
public abstract class ConfigOption<T> {
    @NonNull
    private final String key;
    @NonNull
    private T value;
    @NonNull
    private final T defaultValue;

    /**
     * Creates a new config option with the given key and default value.
     *
     * @param key          the unique key for this option
     * @param defaultValue the default value (also used as the initial value)
     */
    protected ConfigOption(@NonNull String key, @NonNull T defaultValue) {
        this.key = key;
        this.value = defaultValue;
        this.defaultValue = defaultValue;
    }

    /**
     * Returns the unique key for this option.
     *
     * @return the option key
     */
    public @NonNull String getKey() {
        return key;
    }

    /**
     * Returns the current value of this option.
     *
     * @return the current value
     */
    public @NonNull T getValue() {
        return value;
    }

    /**
     * Sets the current value of this option.
     *
     * @param value the new value
     */
    public void setValue(@NonNull T value) {
        this.value = value;
    }

    /**
     * Returns the default value of this option.
     *
     * @return the default value
     */
    public @NonNull T getDefaultValue() {
        return defaultValue;
    }

    /**
     * Returns the runtime {@link Class} object for the value type.
     *
     * @return the value type class
     */
    public abstract Class<T> getType();

    /**
     * Returns the serializer used to convert this option to and from JSON.
     *
     * @return the serializer for this option's value type
     */
    public abstract ConfigOptionSerializer<T> getSerializer();
}
