package net.forscherfreunde.mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelsProvider extends FabricModelProvider {
    public ModModelsProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        //Blockstates und Models
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GetBlock("ruby_block"));
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GetBlock("ruby_ore"));
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GetBlock("ruby_glass"));

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //Items - einfach die Zeile vom Rubin kopieren und anpassen
        itemModelGenerator.register(ModItems.GetItem("ruby"), Models.GENERATED);
        itemModelGenerator.register(ModItems.GetItem("tomato"), Models.GENERATED);

        //Werkzeuge
        itemModelGenerator.register(ModItems.GetItem("ruby_axe"), Models.HANDHELD);
        itemModelGenerator.register(ModItems.GetItem("ruby_hoe"), Models.HANDHELD);
        itemModelGenerator.register(ModItems.GetItem("ruby_shovel"), Models.HANDHELD);
        itemModelGenerator.register(ModItems.GetItem("ruby_pickaxe"), Models.HANDHELD);
        itemModelGenerator.register(ModItems.GetItem("ruby_sword"), Models.HANDHELD);

        //Rüstungen - siehe Doku [Rüstungen]
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GetItem("ruby_helmet"));
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GetItem("ruby_chestplate"));
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GetItem("ruby_leggings"));
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GetItem("ruby_boots"));
    }
}
