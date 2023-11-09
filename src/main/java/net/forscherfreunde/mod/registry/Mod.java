package net.forscherfreunde.mod.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.forscherfreunde.mod.ausruestung.*;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;

import java.util.List;

import static net.forscherfreunde.mod.registry.block.ModBlocks.AllTransparentBlocks;

public class Mod {

    public static void ItemHinzufuegen(String name) {
        ModItems.registerItem(name, new Item(new FabricItemSettings()));
    }

    public static void BlockHinzufuegen(String name, float haerte,
                                        float resistenz,
                                        int leuchtlevel) {
        ModBlocks.registerBlock(name, new Block(FabricBlockSettings
                .copyOf(Blocks.COBBLESTONE).strength(haerte, resistenz)
                .luminance(leuchtlevel).requiresTool()));
    }

    public static void TransparentenBlockHinzufuegen(String name, float haerte,
                                                      float resistenz, int leuchtlevel)
    {
        Block BLOCK = new GlassBlock(FabricBlockSettings
                .copyOf(Blocks.GLASS)
                .luminance(leuchtlevel)
                .requiresTool()
                .strength(haerte, resistenz)
                .nonOpaque());
        ModBlocks.registerBlock(name, BLOCK);

        AllTransparentBlocks.push(BLOCK);
    }

    public static void SpitzhackeHinzufuegen(String name, AusruestungsMaterial material, int angriffsSchaden, float angriffsGeschwindigkeit, ItemGroup itemGruppe, String modid) {
        ToolItem spitzhacke = new CustomPickaxe(material, angriffsSchaden, angriffsGeschwindigkeit, new FabricItemSettings());
        ModItems.registerItem(name, spitzhacke);
    }

    public static void AxtHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem axt = new CustomAxe(material, AngriffsSchaden, AngriffsGeschwindigkeit, new FabricItemSettings());
        ModItems.registerItem(name, axt);
    }

    public static void SchaufelHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem schaufel = new CustomShovel(material, AngriffsSchaden, AngriffsGeschwindigkeit, new FabricItemSettings());
        ModItems.registerItem(name, schaufel);
    }

    public static void FeldhackeHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem feldhacke = new CustomHoe(material, AngriffsSchaden, AngriffsGeschwindigkeit, new FabricItemSettings());
        ModItems.registerItem(name, feldhacke);
    }

    public static void SchwertHinzufuegen(String name, AusruestungsMaterial material, int AngriffsSchaden, float AngriffsGeschwindigkeit, ItemGroup group, String modid) {
        ToolItem schwert = new CustomSword(material, AngriffsSchaden, AngriffsGeschwindigkeit, new FabricItemSettings());
        ModItems.registerItem(name, schwert);
    }

    public static Item HoleItem(String name) {
        return ModItems.GetItem(name);
    }
    public static List<Block> GetAllTransparentBlocks() {return AllTransparentBlocks;}
}
