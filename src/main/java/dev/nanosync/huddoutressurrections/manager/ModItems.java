package dev.nanosync.huddoutressurrections.manager;

import dev.nanosync.huddoutressurrections.Main;
import dev.nanosync.huddoutressurrections.item.chest.EternityChestItem;
import dev.nanosync.huddoutressurrections.item.chest.MinersChestItem;
import dev.nanosync.huddoutressurrections.item.key.EternityKeyItem;
import dev.nanosync.huddoutressurrections.item.key.MinersKeyItem;
import dev.nanosync.huddoutressurrections.item.sword.HuddoutSwordItem;
import dev.nanosync.huddoutressurrections.tab.ItensTab;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MODID);

    // KEY's
    public static final RegistryObject<EternityKeyItem> ETERNITY_KEY = ITEMS.register("eternity_key", () ->
            new EternityKeyItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .group(ItensTab.get)));

    public static final RegistryObject<MinersKeyItem> MINERS_KEY = ITEMS.register("miners_key", () ->
            new MinersKeyItem(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .group(ItensTab.get)));

    // CHEST's
    public static final RegistryObject<EternityChestItem> ETERNITY_CHEST = ITEMS.register("eternity_chest", () ->
            new EternityChestItem(new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .maxStackSize(1)
                    .group(ItensTab.get)));


    public static final RegistryObject<MinersChestItem> MINERS_CHEST = ITEMS.register("miners_chest", () ->
            new MinersChestItem(new Item.Properties()
                    .rarity(Rarity.COMMON)
                    .maxStackSize(1)
                    .group(ItensTab.get)));

    // SWORDS
    public static final RegistryObject<HuddoutSwordItem> HUDDOUT_SWORD = ITEMS.register("huddout_sword", () ->
            new HuddoutSwordItem(ItemTier.NETHERITE, 20, 3, new Item.Properties()
                    .rarity(Rarity.EPIC)
                    .group(ItensTab.get)
                    .maxDamage(300)));
}
