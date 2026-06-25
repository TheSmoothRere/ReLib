package io.github.thesmoothrere.relib.config.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

/**
 * Serialises enum values to and from JSON primitives using {@link Enum#name() the constant name}.
 *
 * @param <E> the enum type
 */
public class EnumOptionSerializer<E extends Enum<E>> implements ConfigOptionSerializer<E> {
    private final Class<E> enumClass;

    /**
     * Creates a serializer for the given enum class.
     *
     * @param enumClass the enum type to serialise
     */
    public EnumOptionSerializer(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public JsonElement serialize(E value) {
        return new JsonPrimitive(value.name());
    }

    @Override
    public E deserialize(JsonElement json) {
        return Enum.valueOf(enumClass, json.getAsString());
    }
}
