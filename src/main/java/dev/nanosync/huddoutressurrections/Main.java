package dev.nanosync.huddoutressurrections;

import dev.nanosync.huddoutressurrections.api.Discord;
import dev.nanosync.huddoutressurrections.manager.ModBlocks;
import dev.nanosync.huddoutressurrections.manager.ModItems;
import dev.nanosync.huddoutressurrections.events.ExplosionEvent;
import dev.nanosync.huddoutressurrections.utils.Giveways;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod("huddoutressurrections")
public class Main {

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static String MODID = "huddoutressurrections";

    public Main() {

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register Forge Client Events
        eventBus.addListener((FMLClientSetupEvent event) -> {
            try {
                setupClientEvent(event);
            } catch (IOException ignored) {}
        });

        // Register Server Events
        eventBus.addListener(this::setupServerEvent);

        // GlobalEvents (Server and Client)
        MinecraftForge.EVENT_BUS.register(new ExplosionEvent());

        // Forge Itens / Blocks registry
        ModItems.ITEMS.register(eventBus);

        // Loaders
        Giveways.loadItensForge();
    }


    public void setupClientEvent(FMLClientSetupEvent event) throws IOException {
        new Discord("913080544428949614");
    }

    public void setupServerEvent(FMLDedicatedServerSetupEvent event){

    }

}
