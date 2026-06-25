package io.github.thesmoothrere.relib.config.option;

import io.github.thesmoothrere.relib.config.serializer.ConfigOptionSerializer;
import io.github.thesmoothrere.relib.config.serializer.EnumOptionSerializer;
import org.jspecify.annotations.NonNull;

/**
 * A configuration option that holds an enum value.
 * <p>
 * The enum class is inferred from the default value's declaring class.
 * Values are serialised using the enum constant's {@link Enum#name() name}.
 * </p>
 *
 * @param <E> the enum type
 */
public class EnumOption<E extends Enum<E>> extends ConfigOption<E> {
    private final Class<E> enumClass;

    /**
     * Creates an enum option with the given key and default value.
     *
     * @param key          the option key
     * @param defaultValue the default value (used to infer the enum class)
     */
    public EnumOption(@NonNull String key, @NonNull E defaultValue) {
        super(key, defaultValue);
        this.enumClass = defaultValue.getDeclaringClass();
    }

    @Override
    public Class<E> getType() {
        return enumClass;
    }

    @Override
    public ConfigOptionSerializer<E> getSerializer() {
        return new EnumOptionSerializer<>(enumClass);
    }
}
