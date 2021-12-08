package dev.nanosync.huddoutressurrections.utils;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.*;
import java.util.stream.Collectors;

public class Giveways {

    private static List<ItemStack> allForgeItems = new ArrayList<>(); // do not place final
    private static List<ItemStack> industrialItems = new ArrayList<>(); // do not place final
    private static List<ItemStack> foodItens = new ArrayList<>(); // do not place final

    public static List<ItemStack> getIndustrialItems(){
        if (industrialItems.size() == 0){
            genForgeItems();
            industrialItems.addAll(getItemsByRegistries(Arrays.asList("mekanism", "industrial")));
        }
        return getItemList(industrialItems);
    }

    public static List<ItemStack> getItemsByRegistries(List<String> registries) {
        List<ItemStack> arrayStack = new ArrayList<>();
        ForgeRegistries.ITEMS.getValues().forEach(item -> {
            registries.forEach(registry -> {
                if (Objects.requireNonNull(item.getRegistryName()).toString().contains(registry)){
                    arrayStack.add(item.getDefaultInstance());
                }
            });
        });
        return arrayStack;
    }

    public static List<ItemStack> genForgeItems(){
        if (allForgeItems.size() == 0){
            ForgeRegistries.ITEMS.getValues().forEach(itemStacksGame -> {
                if (itemStacksGame != null){
                    allForgeItems.add(itemStacksGame.getDefaultInstance()); // DO NOT PUT GETITEM FUNCTION
                }
            });
        }

        return allForgeItems.stream().distinct().collect(Collectors.toList());
    }

    public static List<ItemStack> getItemList(List<ItemStack>  itemStackList){
        if (itemStackList != null){
            return itemStackList;
        } else {
            return new ArrayList<>(Collections.singleton(new ItemStack(Items.AIR, 1)));
        }
    }
}
