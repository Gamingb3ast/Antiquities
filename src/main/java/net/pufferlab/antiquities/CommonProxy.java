package net.pufferlab.antiquities;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        Config.synchronizeConfiguration(event.getSuggestedConfigurationFile());

        Antiquities.LOG.info(Config.greeting);
        Antiquities.LOG.info("Antiquities is at version " + Tags.VERSION);
    }

    public void registerRenders() {}

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}

    public void serverStarting(FMLServerStartingEvent event) {}

    public int getChairRenderID() {
        return 0;
    }

    public int getTableRenderID() {
        return 0;
    }

    public int getGlobeRenderID() {
        return 0;
    }
}
