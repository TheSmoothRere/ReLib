package io.github.thesmoothrere.relib;

import io.github.thesmoothrere.relib.api.Config;
import io.github.thesmoothrere.relib.api.ConfigApi;
import io.github.thesmoothrere.relib.config.ConfigManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import java.util.Collection;

/**
 * Main entry point for the ReLib mod.
 * <p>
 * On initialisation, discovers all {@link ConfigApi} implementations registered in
 * {@code fabric.mod.json} under the {@value Constants#MOD_ID} entrypoint key, validates
 * that each is annotated with {@link Config @Config}, and registers them with
 * {@link ConfigManager}.
 * </p>
 */
public class ReLib implements ModInitializer {
    @Override
    public void onInitialize() {
        Constants.LOGGER.info(Constants.MOD_NAME + " initialized!");

        Collection<ConfigApi> configs = FabricLoader.getInstance().getEntrypoints(Constants.MOD_ID, ConfigApi.class);
        configs.forEach(config -> {
            Class<? extends ConfigApi> configClass = config.getClass();
            if (configClass.isAnnotationPresent(Config.class)) {
                ConfigManager.register(config);
            } else {
                Constants.LOGGER.error("Config class {} is missing @Config annotation", configClass.getName());
            }
        });
    }
}
