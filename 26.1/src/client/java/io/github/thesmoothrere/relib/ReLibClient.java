package io.github.thesmoothrere.relib;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

/**
 * Client-side entry point for the ReLib mod.
 * <p>
 * Currently performs no client-specific setup beyond logging initialisation.
 * </p>
 */
@Environment(EnvType.CLIENT)
public class ReLibClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Constants.LOGGER.info(Constants.MOD_NAME + " client initialized!");
    }
}
