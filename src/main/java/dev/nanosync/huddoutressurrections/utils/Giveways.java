package dev.nanosync.huddoutressurrections.utils;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;

public class Giveways {

    private static List<ItemStack> allForgeItems = new ArrayList<>();
    private static List<ItemStack> oreItems = new ArrayList<>();

    public static List<ItemStack> getOresItems(){
        if (oreItems.size() == 0){
            genForgeItems();
            oreItems.addAll(getItemsByRegistries(Collections.singletonList("ingot")));
        }
        return getItemList(oreItems);
    }


    public static List<ItemStack> getItemsByRegistries(List<String> registries) {
        List<ItemStack> arrayStack = new ArrayList<>();
        for (Item item : ForgeRegistries.ITEMS.getValues()) {
            for (String registry : registries) {
                if (Objects.requireNonNull(item.getRegistryName()).toString().contains(registry)) {
                    arrayStack.add(item.getDefaultInstance());
                }
            }
        }
        return arrayStack;
    }

    public static List<ItemStack> genForgeItems(){
        if (allForgeItems.size() == 0){
            for (Item itemStacksGame : ForgeRegistries.ITEMS.getValues()) {
                if (itemStacksGame != null) {
                    allForgeItems.add(itemStacksGame.getDefaultInstance());
                }
            }
        }

        List<ItemStack> list = new ArrayList<>();
        Set<ItemStack> uniqueValues = new HashSet<>();
        for (ItemStack allForgeItem : allForgeItems) {
            if (uniqueValues.add(allForgeItem)) {
                list.add(allForgeItem);
            }
        }
        return list;
    }

    public static List<ItemStack> getItemList(List<ItemStack>  itemStackList){
        if (itemStackList != null){
            return itemStackList;
        } else {
            return new ArrayList<>(Collections.singleton(new ItemStack(Items.AIR, 1)));
        }
    }
}
