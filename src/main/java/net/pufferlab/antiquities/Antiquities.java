package net.pufferlab.antiquities;

import net.minecraft.util.ResourceLocation;
import net.pufferlab.antiquities.events.EventHandler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;

@Mod(modid = Antiquities.MODID, version = Tags.VERSION, name = "Antiquities", acceptedMinecraftVersions = "[1.7.10]")
public class Antiquities {

    public static final String MODID = "antiquities";
    public static final Logger LOG = LogManager.getLogger(MODID);

    @SidedProxy(
        clientSide = "net.pufferlab.antiquities.ClientProxy",
        serverSide = "net.pufferlab.antiquities.CommonProxy")
    public static CommonProxy proxy;
    public static EventHandler eventHandler = new EventHandler();

    public static Registry registry = new Registry();

    @Mod.Instance(Antiquities.MODID)
    public static Antiquities instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        registry.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);

        registry.init();
        // MinecraftForge.EVENT_BUS.register(eventHandler);

        proxy.registerRenders();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);

        Config.refreshWhitelists();
    }

    @Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        proxy.serverStarting(event);
    }

    public static ResourceLocation asResource(String path) {
        return new ResourceLocation(MODID, path);
    }
}
