package io.github.thesmoothrere.rerelib.config.serializer;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

public class StringOptionSerializer implements ConfigOptionSerializer<String> {
    @Override
    public JsonElement serialize(String value) {
        return new JsonPrimitive(value);
    }

    @Override
    public String deserialize(JsonElement json) {
        return json.getAsString();
    }
}
