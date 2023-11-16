package net.forscherfreunde.mod.registry;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.forscherfreunde.mod.ausruestung.*;
import net.forscherfreunde.mod.entity.CustomModEntities;
import net.forscherfreunde.mod.entity.vorlagen.goals.Ziel;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModFoodComponents;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.GlassBlock;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.item.*;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.List;

import static net.forscherfreunde.mod.registry.block.ModBlocks.AllTransparentBlocks;

public class Mod {

    //Item und Food Test
    public static void ItemHinzufuegen(String name) {
        ModItems.registerItem(name, new Item(new FabricItemSettings()));
    }
    public static void FoodItemHinzufuegen(String name) {
        ModItems.registerItem(name, new Item(new FabricItemSettings().food(ModFoodComponents.TOMATO)));
    }

    //Block Test
    public static void BlockHinzufuegen(String name, float strength,
                                        int leuchtlevel) {
        ModBlocks.registerBlock(name, new Block(FabricBlockSettings
                .copyOf(Blocks.IRON_BLOCK).strength(strength)
                .luminance(leuchtlevel).requiresTool()));
    }

    public static void ErzBlockHinzufuegen(String name, float strength, int leuchtlevel) {
        ModBlocks.registerBlock(name, new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).requiresTool()
                .luminance(leuchtlevel).strength(strength), UniformIntProvider.create(2, 5)));
    }

    public static void TransparentenBlockHinzufuegen(String name, float strength, int leuchtlevel)
    {
        Block BLOCK = new GlassBlock(FabricBlockSettings
                .copyOf(Blocks.GLASS)
                .luminance(leuchtlevel)
                .requiresTool()
                .strength(strength)
                .nonOpaque());
        ModBlocks.registerBlock(name, BLOCK);

        AllTransparentBlocks.push(BLOCK);
    }

    //Werkzeuge/Waffen Test
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

    //Rüstung Test
    public static void RuestungHinzufuegen(String name, ModRuestungsMaterial material, ArmorItem.Type type) {
        ArmorItem armorItem = new ArmorItem(material, type, new FabricItemSettings());
        ModItems.registerItem(name, armorItem);
    }

//    Monster und Tiere Test
    public static void TierHinzufuegen(String name, EntityType.EntityFactory<AnimalEntity> tier, float schattenradius, float breite, float hoehe, String path) {
        CustomModEntities.TierHinzufuegen(name, tier, schattenradius, breite, hoehe, path);
    }
    public static void MonsterHinzufuegen(String name, EntityType.EntityFactory<HostileEntity> monster, EntityModel<? extends PathAwareEntity> model, float schattenradius, float breite, float hoehe, String modid) {
        CustomModEntities.MonsterHinzufuegen(name, monster, model, schattenradius, breite, hoehe, modid);
    }
    public static void AttributHinzufuegen(String name, CustomModEntities.KreaturAttribute attribut, double wert) {
        CustomModEntities.AttributHinzufuegen(name, attribut, wert);
    }
    public static void ZielHinzufuegen(String name, Ziel ziel) {
        CustomModEntities.ZielHinzufuegen(name, ziel);
    }
    public static void AttributeRegistrieren() {
        CustomModEntities.AttributeRegistrieren();
    }


    //Allgemeine Funktionen - getter
    public static Item HoleItem(String name) {
        return ModItems.GetItem(name);
    }
    public static List<Block> GetAllTransparentBlocks() {return AllTransparentBlocks;}
}
