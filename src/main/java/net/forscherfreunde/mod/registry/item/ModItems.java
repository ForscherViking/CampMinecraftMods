package net.forscherfreunde.mod.registry.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.forscherfreunde.mod.TestMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ModItems {

    public static Map<String, Item> Items = new HashMap<>();
    private static Item firstItem = null;

//    public static Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));



    public static Item registerItem(String name, Item item) {
        if(firstItem == null)
            firstItem = item;
        Items.put(name, item);
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("Registering Mod Items for " + TestMod.MOD_ID);
    }
}
