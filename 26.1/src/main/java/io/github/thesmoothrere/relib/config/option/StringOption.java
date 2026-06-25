package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import io.github.thesmoothrere.relib.config.serializer.StringOptionSerializer;
import org.jspecify.annotations.NonNull;

/**
 * A configuration option that holds a {@link String} value.
 */
public class StringOption extends ConfigOption<String> {
    /**
     * Creates a string option with the given key and default value.
     *
     * @param key          the option key
     * @param defaultValue the default value
     */
    public StringOption(@NonNull String key, @NonNull String defaultValue) {
        super(key, defaultValue);
    }

    @Override
    public Class<String> getType() {
        return String.class;
    }

    @Override
    public ConfigOptionSerializer<String> getSerializer() {
        return new StringOptionSerializer();
    }
}
