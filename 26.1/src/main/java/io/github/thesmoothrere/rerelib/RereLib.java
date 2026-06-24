package io.github.thesmoothrere.rerelib;

import net.fabricmc.api.ModInitializer;

public class RereLib implements ModInitializer {
    @Override
    public void onInitialize() {
        Constants.LOGGER.info("Hello Fabric world!");
    }
}
