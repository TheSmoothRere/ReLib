package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.ListString;
import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import io.github.thesmoothrere.relib.config.serializer.ListStringOptionSerializer;
import org.jspecify.annotations.NonNull;

import java.util.Arrays;

/**
 * A configuration option that holds a {@link ListString} value (a list of strings).
 */
public class ListStringOption extends ConfigOption<ListString> {
    /**
     * Creates a list-string option with the given key and default values.
     *
     * @param key          the option key
     * @param defaultValue the default values as varargs
     */
    public ListStringOption(@NonNull String key, @NonNull String... defaultValue) {
        super(key, new ListString(Arrays.asList(defaultValue)));
    }

    @Override
    public Class<ListString> getType() {
        return ListString.class;
    }

    @Override
    public ConfigOptionSerializer<ListString> getSerializer() {
        return new ListStringOptionSerializer();
    }
}
