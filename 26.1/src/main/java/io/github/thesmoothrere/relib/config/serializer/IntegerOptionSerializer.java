package io.github.thesmoothrere.relib.config.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

/**
 * Serialises {@link Integer} values to and from JSON primitives.
 */
public class IntegerOptionSerializer implements ConfigOptionSerializer<Integer> {
    /** No-arg constructor. */
    public IntegerOptionSerializer() {}

    @Override
    public JsonElement serialize(Integer value) {
        return new JsonPrimitive(value);
    }

    @Override
    public Integer deserialize(JsonElement json) {
        return json.getAsInt();
    }
}
