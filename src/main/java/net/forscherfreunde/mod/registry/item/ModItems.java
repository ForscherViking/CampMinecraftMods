package net.forscherfreunde.mod.registry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.forscherfreunde.mod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.*;

public class ModItems {

    public static Map<String, Item> Items = new HashMap<>();
    public static Item firstItem = null;

    public static List<Item> itemList = new ArrayList<>();

    public static Item registerItem(String name, Item item) {
        if(firstItem == null) {
            firstItem = item;
        }
        Items.put(name, item);
        itemList.add(item);
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);
    }
}
