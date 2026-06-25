package io.github.thesmoothrere.relib.config.option;

import org.jspecify.annotations.NonNull;

/**
 * Abstract base class for numeric configuration options with bounded ranges.
 * <p>
 * Validates at construction time that {@code minValue <= defaultValue <= maxValue}
 * and that {@code minValue <= maxValue}.
 * </p>
 *
 * @param <T> the numeric type, must be {@link Number} and {@link Comparable}
 */
public abstract class NumberConfigOption<T extends Number & Comparable<T>> extends ConfigOption<T> {
    @NonNull
    private final T minValue;
    @NonNull
    private final T maxValue;

    /**
     * Creates a bounded numeric option after validating the bounds.
     *
     * @param key          the option key
     * @param defaultValue the default value
     * @param minValue     the minimum allowed value (inclusive)
     * @param maxValue     the maximum allowed value (inclusive)
     * @throws IllegalArgumentException if the bounds are invalid or the default
     *                                  value lies outside the range
     */
    protected NumberConfigOption(@NonNull String key, @NonNull T defaultValue, @NonNull T minValue, @NonNull T maxValue) {
        validateBounds(defaultValue, minValue, maxValue);
        super(key, defaultValue);
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    private static <T extends Number & Comparable<T>> void validateBounds(T defaultValue, T minValue, T maxValue) {
        if (minValue.compareTo(maxValue) > 0) {
            throw new IllegalArgumentException("Min value cannot be greater than max value!");
        }
        if (defaultValue.compareTo(minValue) < 0) {
            throw new IllegalArgumentException("Default value cannot be less than min value!");
        }
        if (defaultValue.compareTo(maxValue) > 0) {
            throw new IllegalArgumentException("Default value cannot be greater than max value!");
        }
    }

    /**
     * Returns the minimum allowed value (inclusive).
     *
     * @return the minimum value
     */
    public @NonNull T getMinValue() {
        return minValue;
    }

    /**
     * Returns the maximum allowed value (inclusive).
     *
     * @return the maximum value
     */
    public @NonNull T getMaxValue() {
        return maxValue;
    }
}
