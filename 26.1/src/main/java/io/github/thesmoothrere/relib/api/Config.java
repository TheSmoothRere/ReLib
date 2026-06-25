package io.github.thesmoothrere.relib.api;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marks a class as a configuration definition for ReLib.
 * <p>
 * Classes annotated with {@code @Config} must also implement {@link ConfigApi}
 * to be discovered and registered by the mod.
 * </p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Config {
    /**
     * The base name of the configuration file (without extension).
     * The resulting file will be {@code <name>.json} in the Minecraft config directory.
     *
     * @return the config file name
     */
    String name();
}
