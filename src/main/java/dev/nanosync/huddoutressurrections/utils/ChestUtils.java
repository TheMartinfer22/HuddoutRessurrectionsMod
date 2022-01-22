package dev.nanosync.huddoutressurrections.utils;

import dev.nanosync.huddoutressurrections.manager.ModItems;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.util.FakePlayer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class ChestUtils {

    public ActionResult<ItemStack> createChest(World worldIn, PlayerEntity playerIn, Hand handIn, ItemStack key, int quantityToGive, String chestKey, Item classForChest, List<ItemStack> itemList, boolean broadcast){
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        playerIn.setActiveHand(handIn);
        if (!handIn.equals(Hand.MAIN_HAND) | playerIn instanceof FakePlayer | worldIn.isRemote()) return ActionResult.resultFail(itemstack);
        if (playerIn.inventory.hasItemStack(key)) {

            // Verify inventory main of player
            if (this.inventoryIsFull(playerIn.inventory.mainInventory)){
                sendFail("inventoryFull", playerIn);
                return ActionResult.resultFail(itemstack);
            }

            // Cooldown setter
            playerIn.getCooldownTracker().setCooldown(classForChest, 60);

            // Variables assign
            int itemSlot = this.getSlotFor(playerIn.inventory, key);
            int quantityOfItem = new Random().nextInt(quantityToGive - 1) + 1; // Abbreviation for line 43

            // Random Item Giveways class
            Item item = itemList.get(new Random().nextInt(itemList.size())).getItem();

            // Inventory add item (First add later remove)
            playerIn.inventory.addItemStackToInventory(new ItemStack(item, quantityOfItem));

            // String[] to converter
            String[] arraysInfosItem = new String[4];
            arraysInfosItem[0] = playerIn.getName().getString();
            arraysInfosItem[1] = new TranslationTextComponent("item.huddoutressurrections." + chestKey).getString();
            arraysInfosItem[2] = this.getNameFor(item.getDefaultInstance()).getString();
            arraysInfosItem[3] = Integer.toString(quantityOfItem);
            if (broadcast){
                sendSuccess(worldIn, playerIn, arraysInfosItem);
            } else {
                ITextComponent textComponent = new TranslationTextComponent("text.huddoutressurrections.chest.no_broadcast_success", arraysInfosItem[2]);
                playerIn.sendStatusMessage(textComponent, true);
            }

            // Clear key and chest
            playerIn.inventory.getStackInSlot(itemSlot).shrink(1);
            itemstack.shrink(1);

            // Added to uses(I do not know this :'()
            playerIn.addStat(Stats.ITEM_USED.get(classForChest));

            // Return (do no change this)
            return ActionResult.func_233538_a_(itemstack, worldIn.isRemote());

        } else {
            sendFail("fail", playerIn);
        }
        return ActionResult.resultFail(itemstack);
    }

    private void sendSuccess(World world, PlayerEntity player, String[] args){
        ITextComponent textComponent = new TranslationTextComponent("text.huddoutressurrections.chest.success", args);
        for (PlayerEntity players : world.getPlayers()) {
            players.sendMessage(textComponent, player.getUniqueID());
        }
    }

    private void sendFail(String key, PlayerEntity player){
        ITextComponent textComponent = new TranslationTextComponent("text.huddoutressurrections.chest." + key);
        player.sendMessage(textComponent, player.getUniqueID());
    }

    private ITextComponent getNameFor(ItemStack itemStack) {
        return new TranslationTextComponent(itemStack.getTranslationKey());
    }

    private boolean stackEqualExact(ItemStack stack1, ItemStack stack2) {
        return stack1.getItem() == stack2.getItem() && ItemStack.areItemStackTagsEqual(stack1, stack2);
    }

    public int getSlotFor(PlayerInventory playerInventory, ItemStack stack) {
        for (int i = 0; i < playerInventory.getSizeInventory(); ++i) {
            if (!playerInventory.getStackInSlot(i).isEmpty() && this.stackEqualExact(stack, playerInventory.getStackInSlot(i))) {
                return i;
            }
        }
        return -1;
    }

    private boolean inventoryIsFull(NonNullList<ItemStack> inventory) {
        for (ItemStack itemStack : inventory) {
            if (itemStack.getItem() == Items.AIR){
                return false;
            }
        }
        return true;
    }

}
