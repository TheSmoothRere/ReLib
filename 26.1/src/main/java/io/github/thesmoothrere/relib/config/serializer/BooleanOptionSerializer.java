package io.github.thesmoothrere.relib.config.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

/**
 * Serialises {@link Boolean} values to and from JSON primitives.
 */
public class BooleanOptionSerializer implements ConfigOptionSerializer<Boolean> {
    /** No-arg constructor. */
    public BooleanOptionSerializer() {}

    @Override
    public JsonElement serialize(Boolean value) {
        return new JsonPrimitive(value);
    }

    @Override
    public Boolean deserialize(JsonElement json) {
        return json.getAsBoolean();
    }
}
