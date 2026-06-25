package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import io.github.thesmoothrere.relib.config.serializer.IntegerOptionSerializer;
import org.jspecify.annotations.NonNull;

/**
 * A bounded configuration option that holds an {@link Integer} value.
 */
public class IntegerOption extends NumberConfigOption<Integer> {
    /**
     * Creates an integer option with the given key, default value, and bounds.
     *
     * @param key          the option key
     * @param defaultValue the default value
     * @param minValue     the minimum allowed value (inclusive)
     * @param maxValue     the maximum allowed value (inclusive)
     */
    public IntegerOption(@NonNull String key, @NonNull Integer defaultValue, @NonNull Integer minValue, @NonNull Integer maxValue) {
        super(key, defaultValue, minValue, maxValue);
    }

    @Override
    public Class<Integer> getType() {
        return Integer.class;
    }

    @Override
    public ConfigOptionSerializer<Integer> getSerializer() {
        return new IntegerOptionSerializer();
    }
}
