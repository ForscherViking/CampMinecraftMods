package net.forscherfreunde.mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.forscherfreunde.mod.ausruestung.ModRuestungsMaterial;
import net.forscherfreunde.mod.entity.ModEntities;
import net.forscherfreunde.mod.entity.custom.PorcupineEntity;
import net.forscherfreunde.mod.registry.Mod;
import net.forscherfreunde.mod.registry.block.ModBlocks;
import net.forscherfreunde.mod.registry.item.ModItemGroups;
import net.forscherfreunde.mod.registry.item.ModItems;
import net.minecraft.item.ArmorItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "forscherfreundemod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		//TestBlöcke und Items - einfach Code kopieren und Namen anpassen.
		Mod.ItemHinzufuegen("ruby");

		Mod.BlockHinzufuegen("ruby_block", 2.0f, 4);
		Mod.ErzBlockHinzufuegen("ruby_ore", 2.0f, 6);
		Mod.TransparentenBlockHinzufuegen("ruby_glass", 1.0f, 10);



		//TestWerkzeuge und Waffen - einfach Code kopieren und Namen und Attribute anpassen.
		Mod.SchwertHinzufuegen("ruby_sword", new RubinMaterial(), 14, 1.6f, ModItemGroups.RUBY_GROUP, MOD_ID);
		Mod.AxtHinzufuegen("ruby_axe", new RubinMaterial(), 12, 1.0f, ModItemGroups.RUBY_GROUP, MOD_ID);
		Mod.FeldhackeHinzufuegen("ruby_hoe", new RubinMaterial(), 5, 1.0f, ModItemGroups.RUBY_GROUP, MOD_ID);
		Mod.SchaufelHinzufuegen("ruby_shovel", new RubinMaterial(), 2, 1.0f, ModItemGroups.RUBY_GROUP, MOD_ID);
		Mod.SpitzhackeHinzufuegen("ruby_pickaxe", new RubinMaterial(), 7, 1.2f, ModItemGroups.RUBY_GROUP, MOD_ID);


		//Test Custom Essen
		Mod.FoodItemHinzufuegen("tomato");

		//Test Custom Rüstung
		Mod.RuestungHinzufuegen("ruby_helmet", ModRuestungsMaterial.RUBY, ArmorItem.Type.HELMET);
		Mod.RuestungHinzufuegen("ruby_chestplate", ModRuestungsMaterial.RUBY, ArmorItem.Type.CHESTPLATE);
		Mod.RuestungHinzufuegen("ruby_leggings", ModRuestungsMaterial.RUBY, ArmorItem.Type.LEGGINGS);
		Mod.RuestungHinzufuegen("ruby_boots", ModRuestungsMaterial.RUBY, ArmorItem.Type.BOOTS);

		//Test Custom Mobs und Animals
		ModEntities.createPorcupineEntity("porcupine", PorcupineEntity::new);




		//Nicht Verändern!! Initialisierung der Mod...
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		FabricDefaultAttributeRegistry.register(ModEntities.ModEntitiesMap.get("porcupine"), PorcupineEntity.createPorcupineAttribute());
	}
}