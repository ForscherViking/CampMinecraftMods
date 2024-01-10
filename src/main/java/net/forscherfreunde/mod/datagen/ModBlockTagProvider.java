package net.forscherfreunde.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        //Für Blöcke die von Spitzhacken abbaubar sind
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GetBlock("ruby_ore"))
                .add(ModBlocks.GetBlock("ruby_block"))
                .add(ModBlocks.GetBlock("ruby_glass"))
        ;

        //Für Blöcke die von Äxten abbaubar sind
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
        ;

        //Für Blöcke die von Schaufeln abbaubar sind
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
        ;

        //Für Blöcke die von Hacken abbaubar sind
        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
        ;

        //Für Blöcke, die schneller durch ein Schwert abbaubar sind
        getOrCreateTagBuilder(BlockTags.SWORD_EFFICIENT)
        ;

        //Für Steinwerkzeuge und höher
        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GetBlock("ruby_glass"))
        ;

        //Für Eisenwerkzeuge und höher
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GetBlock("ruby_block"))
                .add(ModBlocks.GetBlock("ruby_ore"))
        ;

        //Für Diamantwerkzeuge und höher
        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
        ;

        //Für Netherritewerkzeuge und höher
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
        ;

        //Für Customwerkzeuge ab level 5
        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_5")))
        ;
    }
}
