package io.github.thesmoothrere.rerelib;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class RereLibClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        Constants.LOGGER.info("Hello Fabric client world!");
    }
}
