package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.serializer.BooleanOptionSerializer;
import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import org.jspecify.annotations.NonNull;

/**
 * A configuration option that holds a {@link Boolean} value.
 */
public class BooleanOption extends ConfigOption<Boolean> {
    /**
     * Creates a boolean option with the given key and default value.
     *
     * @param key          the option key
     * @param defaultValue the default value
     */
    public BooleanOption(@NonNull String key, @NonNull Boolean defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Class<Boolean> getType() {
        return Boolean.class;
    }

    @Override
    public ConfigOptionSerializer<Boolean> getSerializer() {
        return new BooleanOptionSerializer();
    }
}
