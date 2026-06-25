package io.github.thesmoothrere.relib.config.serializer;

import com.google.gson.JsonElement;

/**
 * Converts config option values to and from Gson {@link JsonElement} representations.
 *
 * @param <T> the value type handled by this serializer
 */
public interface ConfigOptionSerializer<T> {
    /**
     * Serialises a value to a JSON element.
     *
     * @param value the value to serialise
     * @return the JSON representation
     */
    JsonElement serialize(T value);

    /**
     * Deserialises a value from a JSON element.
     *
     * @param json the JSON representation
     * @return the deserialised value
     */
    T deserialize(JsonElement json);
}
