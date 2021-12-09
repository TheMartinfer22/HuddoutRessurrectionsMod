package dev.nanosync.huddoutressurrections.item.chest;

import dev.nanosync.huddoutressurrections.manager.ModItems;
import dev.nanosync.huddoutressurrections.utils.ChestUtils;
import dev.nanosync.huddoutressurrections.utils.Giveways;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.*;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.*;

public class EternityChestItem extends Item {
    public EternityChestItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return new ChestUtils()
                .createChest(worldIn, playerIn, handIn,
                        ModItems.ETERNITY_KEY.get().getDefaultInstance(),
                        5,
                        "eternity_chest",
                        this,
                        Giveways.genForgeItems(),
                        true);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("§6Item necessário para abrir: §dChave da Eternidade"));
        tooltip.add(new StringTextComponent("§6Possui a chance de vir qualquer objeto do jogo."));
    }

    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent(this.getTranslationKey());
    }
}
