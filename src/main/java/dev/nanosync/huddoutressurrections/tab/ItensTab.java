package dev.nanosync.huddoutressurrections.tab;

import dev.nanosync.huddoutressurrections.manager.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ItensTab {
    public static final ItemGroup get = new ItemGroup("tab_huddoutitens") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.KEY_OF_ETERNITY.get());
        }
    };
}
