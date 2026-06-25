package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import io.github.thesmoothrere.relib.config.serializer.DoubleOptionSerializer;
import org.jspecify.annotations.NonNull;

/**
 * A bounded configuration option that holds a {@link Double} value.
 */
public class DoubleOption extends NumberConfigOption<Double> {
    /**
     * Creates a double option with the given key, default value, and bounds.
     *
     * @param key          the option key
     * @param defaultValue the default value
     * @param minValue     the minimum allowed value (inclusive)
     * @param maxValue     the maximum allowed value (inclusive)
     */
    public DoubleOption(@NonNull String key, @NonNull Double defaultValue, @NonNull Double minValue, @NonNull Double maxValue) {
        super(key, defaultValue, minValue, maxValue);
    }

    @Override
    public Class<Double> getType() {
        return Double.class;
    }

    @Override
    public ConfigOptionSerializer<Double> getSerializer() {
        return new DoubleOptionSerializer();
    }
}
