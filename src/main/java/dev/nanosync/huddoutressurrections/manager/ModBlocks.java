package dev.nanosync.huddoutressurrections.manager;

import dev.nanosync.huddoutressurrections.Main;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {


    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MODID);

//    public static final RegistryObject<Block> ROCK_BLOCK = BLOCKS.register("teste", () ->
//            new ItemTeste(new Item.Properties().group(ItemGroup.MISC)));

    public static void register(IEventBus iEventBus){
        BLOCKS.register(iEventBus);
    }
}
