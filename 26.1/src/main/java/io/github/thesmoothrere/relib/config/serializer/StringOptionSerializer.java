package io.github.thesmoothrere.relib.config.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

/**
 * Serialises {@link String} values to and from JSON primitives.
 */
public class StringOptionSerializer implements ConfigOptionSerializer<String> {
    /** No-arg constructor. */
    public StringOptionSerializer() {}

    @Override
    public JsonElement serialize(String value) {
        return new JsonPrimitive(value);
    }

    @Override
    public String deserialize(JsonElement json) {
        return json.getAsString();
    }
}
