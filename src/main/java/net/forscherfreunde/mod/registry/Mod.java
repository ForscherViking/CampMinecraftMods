package net.forscherfreunde.mod.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;

public class Mod {

    public static void ItemHinzufuegen(String name) {
        ModItems.registerItem(name, new Item(new FabricItemSettings()));
    }

    public static void BlockHinzufuegen(String name, float haerte,
                                        float resistenz,
                                        int leuchtlevel) {
        ModBlocks.registerBlock(name, new Block(FabricBlockSettings
                .copyOf(Blocks.IRON_BLOCK).hardness(haerte).resistance(resistenz)
                .luminance(leuchtlevel)));
    }
}
