package net.forscherfreunde.mod.registry.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.forscherfreunde.mod.TestMod;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ModBlocks {

    public static Stack<Block> AllTransparentBlocks = new Stack<Block>();
    public static List<Block> blockList = new ArrayList<>();

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        blockList.add(block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {

        TestMod.LOGGER.info("Registering Blocks for " + TestMod.MOD_ID);
    }

}
