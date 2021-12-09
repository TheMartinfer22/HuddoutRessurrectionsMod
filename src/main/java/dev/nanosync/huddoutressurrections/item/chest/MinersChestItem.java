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
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MinersChestItem extends Item {
    public MinersChestItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        return new ChestUtils().createChest(worldIn,
                playerIn,
                handIn,
                ModItems.MINERS_CHEST.get().getDefaultInstance(),
                6, // Do not put 1
                "miners_chest",
                this,
                Giveways.getOresItems(),
        false);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new StringTextComponent("§6Item necessário para abrir: §fChave do Minerador"));
        tooltip.add(new StringTextComponent("§6Possui a chance de vir minérios"));
    }

    @Override
    public ITextComponent getName() {
        return new TranslationTextComponent(this.getTranslationKey());
    }
}
