package dev.nanosync.huddoutressurrections.utils;

import net.minecraft.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Giveways {

//    public static int GIVEWAYS_SIZE;
    public static List<ItemStack> ITEMS_REGISTRY_FORGE = new ArrayList<>();

//    public static List<Item> getGiveways(){
//        List<Item> itemList = new ArrayList<>();
//        itemList.add(getItemByRegistry("minecraft:diamond"));
//        itemList.add(getItemByRegistry("minecraft:gold_ingot"));
//        itemList.add(getItemByRegistry("minecraft:stone"));
//        itemList.add(getItemByRegistry("minecraft:dirt"));
//        itemList.add(getItemByRegistry("minecraft:redstone"));
//        itemList.add(getItemByRegistry("minecraft:emerald"));
//        GIVEWAYS_SIZE = itemList.size();
//        return itemList;
//    }

//    public static Item getItemByRegistry(String registry) {
//        AtomicReference<Item> item2 = new AtomicReference<>();
//        ForgeRegistries.ITEMS.getValues().forEach(item -> {
//            if (Objects.requireNonNull(item.getRegistryName()).toString().equals(registry)){
//                item2.set(item);
//            }
//        });
//        return item2.get();
//    }

    public static void loadItensForge(){
        ForgeRegistries.ITEMS.getValues().forEach(itemStacksGame -> {
            ITEMS_REGISTRY_FORGE.add(itemStacksGame.getDefaultInstance());
        });
    }

    private ItemStack getRandomItemGame(){
        return ITEMS_REGISTRY_FORGE.get(new Random().nextInt(Giveways.ITEMS_REGISTRY_FORGE.size()));
    }
}
