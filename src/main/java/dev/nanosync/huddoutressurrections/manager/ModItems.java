package dev.nanosync.huddoutressurrections.manager;

import dev.nanosync.huddoutressurrections.Main;
import dev.nanosync.huddoutressurrections.item.chest.ChestOfEternityItem;
import dev.nanosync.huddoutressurrections.item.chest.ChestOfTechnologicItem;
import dev.nanosync.huddoutressurrections.item.key.KeyOfEternityItem;
import dev.nanosync.huddoutressurrections.item.key.KeyOfTechnologicItem;
import dev.nanosync.huddoutressurrections.tab.ItensTab;
import net.minecraft.item.Item;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    // KEY's
    public static final RegistryObject<KeyOfEternityItem> KEY_OF_ETERNITY = ITEMS.register("key_of_eternity", () ->
            new KeyOfEternityItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .group(ItensTab.get)));

    public static final RegistryObject<KeyOfTechnologicItem> KEY_OF_TECHNOLOGY = ITEMS.register("key_of_technology", () ->
            new KeyOfTechnologicItem(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .group(ItensTab.get)));

    // CHEST's
    public static final RegistryObject<ChestOfEternityItem> CHEST_OF_ETERNITY = ITEMS.register("chest_of_eternity", () ->
            new ChestOfEternityItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .maxStackSize(1)
                    .group(ItensTab.get)));

    public static final RegistryObject<ChestOfTechnologicItem> CHEST_OF_TECHNOLOGY = ITEMS.register("chest_of_technology", () ->
            new ChestOfTechnologicItem(new Item.Properties()
                    .rarity(Rarity.RARE)
                    .maxStackSize(1)
                    .group(ItensTab.get)));




}
