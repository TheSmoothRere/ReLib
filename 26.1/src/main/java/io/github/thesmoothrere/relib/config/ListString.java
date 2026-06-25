package io.github.thesmoothrere.relib.config;

import java.util.ArrayList;
import java.util.List;

/**
 * A mutable wrapper around a {@link List} of strings used as the value type
 * for {@link io.github.thesmoothrere.relib.config.option.ListStringOption ListStringOption}.
 * <p>
 * The canonical constructor defensively copies the provided list so that
 * external mutations do not affect the stored state.
 * </p>
 *
 * @param values the underlying list of strings
 */
public record ListString(List<String> values) {
    /**
     * Creates a {@code ListString} with a defensive copy of the given list.
     *
     * @param values the initial string values
     */
    public ListString(List<String> values) {
        this.values = new ArrayList<>(values);
    }

    /**
     * Appends a value to the end of the list.
     *
     * @param value the value to add
     */
    public void add(String value) {
        this.values.add(value);
    }

    /**
     * Replaces the first occurrence of {@code oldValue} with {@code newValue}.
     *
     * @param oldValue the value to replace
     * @param newValue the replacement value
     */
    public void edit(String oldValue, String newValue) {
        int index = this.values.indexOf(oldValue);
        if (index != -1) this.values.set(index, newValue);
    }

    /**
     * Removes the first occurrence of the given value.
     *
     * @param value the value to remove
     */
    public void remove(String value) {
        this.values.remove(value);
    }

    /**
     * Removes all values from the list.
     */
    public void clear() {
        this.values.clear();
    }
}
