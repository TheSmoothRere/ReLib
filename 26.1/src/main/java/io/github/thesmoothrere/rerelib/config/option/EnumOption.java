package io.github.thesmoothrere.rerelib.config.option;

import io.github.thesmoothrere.rerelib.config.serializer.ConfigOptionSerializer;
import io.github.thesmoothrere.rerelib.config.serializer.EnumOptionSerializer;
import org.jspecify.annotations.NonNull;

public class EnumOption<E extends Enum<E>> extends ConfigOption<E> {
    private final Class<E> enumClass;

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
